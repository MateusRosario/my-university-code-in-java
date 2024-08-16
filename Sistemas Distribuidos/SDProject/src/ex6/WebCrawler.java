package ex6;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public final String classPath;
    private final String startLinksDirectory;
    private final String searchingWordsDirectory;
    public final String resultDirectory;
    private final List<String> links = new ArrayList<String>();
    private final List<Crawler> crawlers = new ArrayList<Crawler>();
    public final List<String> words = new ArrayList<String>();
    public final List<Integer> wordsCounters = new ArrayList<Integer>();

    private final int maxCrawlers;
    private final int maxLinksReadings;

    private int linksIndex = 0;
    private boolean running = true;

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler(1000, 60, "links.txt", "words.txt", "result.txt");
        webCrawler.start();
    }

    public WebCrawler(int maxLinksReadings, int maxCrawlers, String startLinksDirectory, String searchingWordsDirector, String resultDirectory) {
        this.maxLinksReadings = maxLinksReadings;
        this.maxCrawlers = maxCrawlers;
        this.startLinksDirectory = startLinksDirectory;
        this.searchingWordsDirectory = searchingWordsDirector;
        this.resultDirectory = resultDirectory;

        this.classPath = WebCrawler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

    private void start() {
        try {
            //Apagando arquivo anterior
            new FileWriter(this.classPath + this.resultDirectory, false);
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + this.classPath + this.resultDirectory + "'");
        }

        try {
            FileReader fileReader = new FileReader(this.classPath + this.startLinksDirectory);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                this.links.add(line);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File '" + this.classPath + this.startLinksDirectory + "' does not exist");
            return;
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        try {
            FileReader fileReader = new FileReader(this.classPath + this.searchingWordsDirectory);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                this.words.add(line);
                this.wordsCounters.add(0);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File '" + this.classPath + this.searchingWordsDirectory + "' does not exist");
            return;
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        //Creating Matchers to find the words on the pages
        List<Pattern> wordFinderPatterns = new ArrayList<Pattern>();
        for (String word : words) {
            wordFinderPatterns.add(Pattern.compile("\\b(" + word + ")\\b"));
        }

        // start
        Crawler newCrawler;
        completeReadings();
        while ( running ) {
            if(crawlers.size() <= maxCrawlers){
                if (this.linksIndex < this.links.size()){
                    newCrawler = new Crawler(this.links.get(this.linksIndex), this, wordFinderPatterns);
                    crawlers.add(newCrawler);
                    newCrawler.start();
                    System.out.println("Thread Started on " + this.links.get(this.linksIndex));
                    this.linksIndex ++;
                } else {
                    System.out.println("Waiting for more links to Crawl\n...");
                    try {
                        Thread.sleep(1000);
                    } catch ( InterruptedException e ){
                        System.out.println("Waiting Error: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("No space for new threads Available");
                System.out.println("Waiting for some thread finish its work\n...");
                try {
                    Thread.sleep(1000);
                } catch ( InterruptedException e ){
                    System.out.println("Waiting Error: " + e.getMessage());
                }
            }

            completeReadings();
        }

        int counter = 0;
        while (this.crawlers.size() > 0){
            try {
                if(counter > 15) {
                    System.out.println("Taking too long... Stooping Anyway");
                    break;
                }
                Thread.sleep(1000);
                counter++;
            } catch ( InterruptedException e ){
                System.out.println("Waiting Error: " + e.getMessage());
            }
            System.out.println("\nWaiting " + this.crawlers.size() + " Crawlers to finish their tasks\n...");
        }

        System.out.println("\n\n\n ----------------------------------------------------------------------------------------- ");
        System.out.println("  Crawling Completed");
        System.out.println("  " + this.links.size() + " links found");
        System.out.println("  " + this.linksIndex + " links crawled with success");
        for (int i = 0; i < words.size(); i++) {
            System.out.println("  " + this.wordsCounters.get(i) + " Occurrences of '" + words.get(i) + "' Found.");
        }
        System.out.println("  Results File Path: " + this.classPath + this.resultDirectory);
        System.out.println(" ----------------------------------------------------------------------------------------- ");

        return;
    }

    public void completeReadings() {
        if (this.linksIndex >= this.maxLinksReadings) {
            System.out.println("Links Readings Completed");
            this.running = false;
        }
    }

    public void addLink(String link) {
        if (!((this.links.contains(link)) || (link.endsWith(".png")) || (link.endsWith(".jpg")) || (link.endsWith(".gif")) || (link.endsWith(".PNG")) || (link.endsWith(".JPG") || (link.endsWith(".GIF"))))){
            this.links.add(link);
            //System.out.println("Link '" + link + "' Added.");
        }
    }

    public void removeCrawler(Crawler crawler) {
        this.crawlers.remove(crawler);
    }
}

class Crawler extends Thread {
    String link;
    WebCrawler master;
    Pattern linkPattern = Pattern.compile("((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
    List<Pattern> wordFinderPatterns;
    private final List<Integer> results = new ArrayList<Integer>();

    Crawler(String link, WebCrawler master, List<Pattern> wordFinderPatterns){
        super();
        this.master = master;
        this.link = link;
        this.wordFinderPatterns = wordFinderPatterns;
    }

    public void run() {
        for(String word: this.master.words){
            this.results.add(0);
        }

        System.out.println("Crawling '" + this.link + "' ...");
        URL url = verifyURL();
        if (url == null) {
            this.master.removeCrawler(this);
            System.out.println("Finishing Crawler");
            return;
        }

        try {
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader buffer = new BufferedReader(reader);

            String line = buffer.readLine();
            while (line != null) {
                getUrls(line);
                countWords(line);
                //System.out.println("Crawler '" + this.link + "': \n" + line);
                line = buffer.readLine();
            }

            for (int result: this.results){
                if(result > 0){
                    writeResults();
                    break;
                }
            }

        } catch ( Exception e) {
            System.out.println("Crawling Error: " + e.getMessage());
            this.master.removeCrawler(this);
        }

        this.master.removeCrawler(this);
    }

    private void countWords(String line){
        for (int i = 0; i < this.wordFinderPatterns.size(); i ++) {
            int counter = 0;
            Matcher matcher = this.wordFinderPatterns.get(i).matcher(line);
            while (matcher.find()){
                counter ++;
            }
            this.results.set(i, this.results.get(i) + counter);
            this.master.wordsCounters.set(i, this.master.wordsCounters.get(i) + counter);
        }
    }

    private void writeResults(){
        StringBuilder results = new StringBuilder();

        results.append("'").append(this.link).append("': \n");

        for(int i = 0; i < this.results.size(); i ++) {
            if(this.results.get(i) != 0){
                results.append(this.master.words.get(i)).append(": ").append(this.results.get(i)).append("\n");
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(this.master.classPath + this.master.resultDirectory, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(results.toString());

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '" + this.master.classPath + this.master.resultDirectory + "'");
        }
    }

    private void getUrls(String line) {
        Matcher pageMatcher = linkPattern.matcher(line);
        while(pageMatcher.find()){
            this.master.addLink(pageMatcher.group());
        }
    }

    private URL verifyURL(){
        try {
            return new URL(this.link);
        } catch ( MalformedURLException e ) {
            System.out.println("  Url " + this.link + " is invalid");
            return null;
        }
    }
}