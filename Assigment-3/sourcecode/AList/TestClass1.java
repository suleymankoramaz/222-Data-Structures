package AList;
import java.util.ArrayList;
public class TestClass1{
    
    public static void main(String[] args){
        
        System.out.println("...SCENARIO 1...\n");
        long startTime = System.nanoTime();

        ArrayList<Account> accounts = new ArrayList<Account>(3);

        System.out.println("...Creating accounts...");
        Account gizemsungu = new Account("gizemsungu","01.01.2000","Istanbul",1);
        Account sibelgulmez = new Account("sibelgulmez", "10.03.1995", "Istanbul", 2);
        Account gokhankaya = new Account("gokhankaya", "03.03.2000", "Ankara", 3);
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        
        System.out.printf("An account with username %s has been created.\n",gizemsungu.getUsername());
        System.out.printf("An account with username %s has been created.\n",sibelgulmez.getUsername());
        System.out.printf("An account with username %s has been created.\n",gokhankaya.getUsername());

        System.out.println("...Loggin into an account (username: sibelgulmez)...");
        sibelgulmez.login(accounts);

        System.out.println("...Sharing two posts...");
        Post post01 = new Post(1,0,"I like Java.");
        Post post02 = new Post(2,0,"Java the coffee..");
        sibelgulmez.sharePost(post01);
        sibelgulmez.sharePost(post02);

        System.out.println("...Following gizemsungu and gokhankaya...");
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.follow(gizemsungu);

        System.out.println("...Logging out from account 'sibelgulmez'...");
        sibelgulmez.logout();

        System.out.println("...Logging into another account (username: gokhankaya)...");
        gokhankaya.login(accounts);

        System.out.println("...Viewing sibelgulmez's profile...");
        gokhankaya.viewProfile(sibelgulmez);

        System.out.println("...Viewing sibelgulmez's posts...");
        gokhankaya.viewPosts(sibelgulmez);

        System.out.println("...Like a post of sibelgulmez...");
        gokhankaya.like(1, sibelgulmez);

        System.out.println("...Adding a comment on a post of sibelgulmez...");
        gokhankaya.comment(1, sibelgulmez, "me too!");

        System.out.println("...Following sibelgulmez and gizemsungu...");
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);

        System.out.println("...Sending a message to gizemsungu...");
        gokhankaya.sendMessage("This homework is too easy!", gizemsungu);

        System.out.println("...Logging out from account 'gokhankaya'...");
        gokhankaya.logout();

        System.out.println("...Logging into another account (username: gizemsungu)...");
        gizemsungu.login(accounts);

        System.out.println("...Checking outbox...");
        ArrayList<Message> temp;
        temp = gizemsungu.getOutbox();
        System.out.printf("There is/are %d messages in the outbox.\n",temp.size());

        System.out.println("...Checking inbox...");
        temp = gizemsungu.getInbox();
        System.out.printf("There is/are %d messages in the inbox.\n",temp.size());

        System.out.println("...Viewing inbox...");
        gizemsungu.checkInbox();

        System.out.println("...Viewing sibelgulmez's profile...");
        gizemsungu.viewProfile(sibelgulmez);
        
        System.out.println("...Viewing sibelgulmez's posts...");
        gizemsungu.viewPosts(sibelgulmez);

        System.out.println("...Viewing sibelgulmez's posts's interactions...");
        gizemsungu.viewInteractions(sibelgulmez, accounts);

        System.out.println("...Liking sibelgulmez's posts...");
        gizemsungu.like(1,sibelgulmez);
        gizemsungu.like(2,sibelgulmez);

        System.out.println("...Viewing sibelgulmez's posts's interactions...");
        gizemsungu.viewInteractions(sibelgulmez, accounts);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}