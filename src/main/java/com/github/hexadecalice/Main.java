package com.github.hexadecalice;
import java.util.HashSet;
import java.net.ConnectException;
	public class Main 
{
    public static void main( String[] args ) throws Exception
    {

    	if(args.length < 2) { 
    		System.out.println("Usage: mvn exec:java -Dexec.args=\"<wordlist> <hostname>\"");
    		return;
    	} 
    	else { 
				try { 
					HashSet<String> results = FileUtils.readWordList(args[0]);
					Crawler.crawl(results, args[1]);	
				}
				catch(ConnectException e){ 
					System.out.println("Couldn't connnect to host, check your internet and URL format.");
					System.out.println("URLs must be formatted as hostname.com (or .org, .net, etc)");
				}
		}	
		
		
        
        
        
        
        
        
        
    }
}
