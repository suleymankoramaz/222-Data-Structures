package LList;
import java.util.LinkedList;

public class TestClass4{

    public static void main(String[] args) throws InterruptedException{
        long startTime = System.nanoTime();
        LinkedList<Account> accounts = new LinkedList<Account>();

        System.out.println("...SCENARIO 4...\n");
        System.out.println("...Creating accounts...");
        Account merve       = new Account("merve", "27.07.2000", "Ankara", 0);
        Account gizemsungu  = new Account("gizemsungu","01.01.2000","Istanbul",1);
        Account sibelgulmez = new Account("sibelgulmez", "10.03.1995", "Istanbul", 2);
        Account gokhankaya  = new Account("gokhankaya", "03.03.2000", "Ankara", 3);
        Account suleyman    = new Account("suleyman","06.06.2001","Istanbul",4);
        Account dogukan     = new Account("dogukan", "13.07.2001", "Istanbul", 5);
        Account emre        = new Account("emre", "13.06.2000", "Ankara", 6);
        Account fatma       = new Account("fatma","07.01.2001","Istanbul",7);
        Account bilal       = new Account("bilal", "20.07.2005", "Istanbul", 8);
        Account emine       = new Account("emine", "09.09.2013", "Ankara", 9);
        
        accounts.add(merve);
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(suleyman);
        accounts.add(dogukan);
        accounts.add(emre);
        accounts.add(fatma);
        accounts.add(bilal);
        accounts.add(emine);
        
        //----------------------UNLIKE----------------------------//
        System.out.println("\n...UNLIKE...\n");

        merve.login(accounts);
        Post post01 = new Post(1,0,"I like Gebze.");
        merve.sharePost(post01);
        merve.logout();

        suleyman.login(accounts);
        suleyman.viewProfile(merve);
        
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS BEFORE SULEYMAN LIKE\n");
        suleyman.viewPosts(merve);
        suleyman.viewInteractions(merve , accounts);

        suleyman.like(1 , merve);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER SULEYMAN LIKE\n");
        suleyman.logout();

        dogukan.login(accounts);
        dogukan.viewProfile(merve);
        
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS BEFORE DOGUKAN LIKE\n");
        dogukan.viewPosts(merve);
        dogukan.viewInteractions(merve , accounts);

        dogukan.like(1 , merve);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER DOGUKAN LIKE\n");
        dogukan.logout();

        suleyman.login(accounts);
        suleyman.viewPosts(merve);
        suleyman.viewInteractions(merve , accounts);
        suleyman.unlike(1 , merve);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER SULEYMAN UNLIKE POST 1\n");
        suleyman.logout();

        dogukan.login(accounts);
        dogukan.viewPosts(merve);
        dogukan.viewInteractions(merve , accounts);
        dogukan.unlike(1 , merve);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER DOGUKAN UNLIKE POST 1\n");
        dogukan.viewPosts(merve);
        dogukan.viewInteractions(merve , accounts);
        dogukan.logout();

        //----------------------UNCOMMENT----------------------------//
        System.out.println("\n...UNCOMMENT...\n"); 
                    
        emine.login(accounts);
        Post post02 = new Post(1,9,"I am Developer.");
        emine.sharePost(post02);
        emine.logout();

        gizemsungu.login(accounts);
        gizemsungu.viewProfile(emine);
        
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS BEFORE GIZEM COMMENT\n");
        gizemsungu.viewPosts(emine);
        gizemsungu.viewInteractions(emine , accounts);

        gizemsungu.comment(1 , emine , "i am gizem");
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER GIZEM COMMENT\n");
        gizemsungu.viewPosts(emine);
        gizemsungu.viewInteractions(emine , accounts);
        gizemsungu.logout();

        sibelgulmez.login(accounts);
        sibelgulmez.viewProfile(emine);
        
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS BEFORE SIBEL COMMENT\n");
        sibelgulmez.viewPosts(emine);
        sibelgulmez.viewInteractions(emine , accounts);

        sibelgulmez.comment(1 , emine , "i am sibel");
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER SIBEL COMMENT\n");
        sibelgulmez.logout();

        gizemsungu.login(accounts);
        gizemsungu.viewProfile(emine);
        gizemsungu.viewPosts(emine);
        gizemsungu.viewInteractions(emine , accounts);
        gizemsungu.uncomment(1 , emine , 0);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER GIZEM UNCOMMENT POST 1\n");
        gizemsungu.logout();

        sibelgulmez.login(accounts);
        sibelgulmez.viewProfile(emine);
        sibelgulmez.viewPosts(emine);
        sibelgulmez.viewInteractions(emine , accounts);
        sibelgulmez.uncomment(1 , emine , 1);
        System.out.println("\n-----------------------------");
        System.out.println("INTERACTIONS AFTER SIBEL UNCOMMENT POST 1\n");
        sibelgulmez.viewPosts(emine);
        sibelgulmez.viewInteractions(emine , accounts);
        sibelgulmez.logout();

        //-------------------------UNFOLLOW--------------------------//
        System.out.println("\n...UNFOLLOW...\n"); 

        dogukan.login(accounts);

        System.out.println("\n-----------------------------");
        System.out.println("DOGUKAN'S PROFILE BEFORE FOLLOWING EMRE AND GOKHANKAYA\n"); 
        dogukan.viewProfile(dogukan); 

        
        dogukan.follow(emre);
        System.out.println("\n-----------------------------");
        System.out.println("DOGUKAN'S PROFILE AFTER FOLLOWING EMRE\n");
        dogukan.viewProfile(dogukan); 

        dogukan.follow(gokhankaya);
        System.out.println("\n-----------------------------");
        System.out.println("DOGUKAN'S PROFILE AFTER FOLLOWING GOKHANKAYA\n");
        dogukan.viewProfile(dogukan); 
        
        dogukan.unfollow(emre);
        System.out.println("\n-----------------------------");
        System.out.println("DOGUKAN'S PROFILE AFTER UNFOLLOWING EMRE\n");
        dogukan.viewProfile(dogukan);

        dogukan.unfollow(gokhankaya);
        System.out.println("\n-----------------------------");
        System.out.println("DOGUKAN'S PROFILE AFTER UNFOLLOWING GOKHANKAYA\n");
        dogukan.viewProfile(dogukan);

        dogukan.logout();

        //-------------------------UNBLOCK--------------------------//
        System.out.println("\n...UNBLOCK...\n"); 

        System.out.println("\n-----------------------------");
        System.out.println("BILAL FOLLOWING EMINE\n");
        bilal.login(accounts);
        bilal.follow(emine);
        bilal.logout();

        System.out.println("\n-----------------------------");
        System.out.println("FATMA FOLLOWING EMINE\n");
        fatma.login(accounts);
        fatma.follow(emine);
        fatma.logout();

        emine.login(accounts);

        System.out.println("\n-----------------------------");
        System.out.println("EMINE VIEW BILAL'S PROFILE BEFORE BLOCK AND BLOCK\n");
        emine.viewProfile(bilal);
        emine.block(bilal);

        System.out.println("\n-----------------------------");
        System.out.println("EMINE VIEW FATMA'S PROFILE BEFORE BLOCK AND BLOCK\n");
        emine.viewProfile(fatma);
        emine.block(fatma);
        emine.logout();

        System.out.println("\n-----------------------------");
        System.out.println("BILAL TRY TO VIEW EMINE'S PROFILE\n");
        bilal.login(accounts);
        bilal.viewProfile(emine);
        bilal.logout();

        System.out.println("\n-----------------------------");
        System.out.println("FATMA TRY TO VIEW EMINE'S PROFILE\n");
        fatma.login(accounts);
        fatma.viewProfile(emine);
        fatma.logout();

        System.out.println("\n-----------------------------");
        System.out.println("EMINE UNBLOCK BILAL\n");
        emine.login(accounts);
        emine.unblock(bilal);
        emine.logout();

        System.out.println("\n-----------------------------");
        System.out.println("BILAL TRY TO VIEW EMINE'S PROFILE\n");
        bilal.login(accounts);
        bilal.viewProfile(emine);
        bilal.logout();

        System.out.println("\n-----------------------------");
        System.out.println("EMINE UNBLOCK FATMA\n");
        emine.login(accounts);
        emine.unblock(fatma);
        emine.logout();

        System.out.println("\n-----------------------------");
        System.out.println("FATMA TRY TO VIEW EMINE'S PROFILE\n");
        fatma.login(accounts);
        fatma.viewProfile(emine);
        fatma.logout(); 

        System.out.println("\n-----------------------------");
        System.out.println("BILAL TRY TO VIEW EMINE'S PROFILE\n");
        bilal.login(accounts);
        bilal.viewProfile(emine);
        bilal.logout(); 
        
        //-------------------------HISTORY--------------------------//

        emine.login(accounts);

        System.out.println("\n-----------------------------");
        System.out.println("MERVE TRY TO VIEW HISTORY WITHOUT LOGIN\n");
        merve.showHistory();

        System.out.println("\n-----------------------------");
        System.out.println("EMINE TRY TO VIEW HISTORY WITH LOGIN\n");
        emine.showHistory();
        System.out.println("\n-----------------------------");

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}