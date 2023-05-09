package LList;
import java.util.LinkedList;
public class TestClass2{

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        LinkedList<Account> accounts = new LinkedList<Account>();

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
        LinkedList<Message> temp;
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

        System.out.println("\n\n...SCENARIO 2...\n\n");
        
        System.out.println("\n\n...Try to logging into logged in account (gizemsungu)...");
        gizemsungu.login(accounts);

        System.out.println("...Sharing two posts...");
        Post post1 = new Post(1,gizemsungu.getAccountID(),"Online education is too bad..");
        Post post2 = new Post(2,gizemsungu.getAccountID(),"I became a Senior Developer!!");
        gizemsungu.sharePost(post1);
        gizemsungu.sharePost(post2);

        System.out.println("...Logging out from account (gizemsungu)...");
        gizemsungu.logout();

        System.out.println("...Logging in into account (sibelgulmez)...");
        sibelgulmez.login(accounts);

        System.out.println("...Viewing gizemsungu's profile...");
        sibelgulmez.viewProfile(gizemsungu);

        System.out.println("...Viewing gizemsungu's posts...");
        sibelgulmez.viewPosts(gizemsungu);

        System.out.println("...Viewing gizemsungu's posts's interactions...");
        sibelgulmez.viewInteractions(gizemsungu, accounts);

        System.out.println("...Liking Post1 of gizemsungu...");
        sibelgulmez.like(1,gizemsungu);

        System.out.println("...Logging out from account (sibelgulmez)...");
        sibelgulmez.logout();

        System.out.println("...Logging in into account (gokhankaya)...");
        gokhankaya.login(accounts);

        System.out.println("...Viewing gizemsungu's profile...");
        gokhankaya.viewProfile(gizemsungu);

        System.out.println("...Viewing gizemsungu's posts...");
        gokhankaya.viewPosts(gizemsungu);

        System.out.println("...Viewing gizemsungu's posts's interactions...");
        gokhankaya.viewInteractions(gizemsungu, accounts);

        System.out.println("...Commenting on Post2 of gizemsungu...");
        gokhankaya.comment(2, gizemsungu, "Nice!");

        System.out.println("...Sending message to gizemsungu...");
        gokhankaya.sendMessage("Hello!", gizemsungu);
        
        System.out.println("...Logging out from account (gokhankaya)...");
        gokhankaya.logout();
        
        System.out.println("...Logging in into account (gizemsungu)...");
        gizemsungu.login(accounts);

        System.out.println("...Viewing her own profile...");
        gizemsungu.viewProfile(gizemsungu);

        System.out.println("...Viewing her own posts...");
        gizemsungu.viewPosts(gizemsungu);

        System.out.println("...Viewing her own posts's interactions...");
        gizemsungu.viewInteractions(gizemsungu, accounts);

        System.out.println("...Viewing inbox...");
        gizemsungu.checkInbox();

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}