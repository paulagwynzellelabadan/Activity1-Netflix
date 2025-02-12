import java.util.Scanner;

public class SimpleNetflixCLI {
    
    
    static class Movie {
        String title;
        String description;

     
        public Movie(String title, String description) {
            this.title = title;
            this.description = description;
        }
        
    
        public void displayDetails() {
            System.out.println("\nTitle: " + title);
            System.out.println("Description: " + description);
        }
    }

    public static void main(String[] args) {
     
        Movie[] actionMovies = {
            new Movie("Fast X", "The latest entry in the Fast and Furious franchise."),
            new Movie("John Wick 5", "Keanu Reeves returns for another action-packed adventure.")
        };
        
        Movie[] comedyMovies = {
            new Movie("The Super Mario Movie", "An animated adventure based on the popular game."),
            new Movie("Barbie", "A satirical comedy about the iconic doll.")
        };
        
       
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Welcome to Simple Netflix CLI ===");
            System.out.println("1. Action Movies");
            System.out.println("2. Comedy Movies");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int genreChoice = scanner.nextInt();
            
           
            if (genreChoice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            
            Movie[] selectedMovies = null;

           
            if (genreChoice == 1) {
                selectedMovies = actionMovies;
            } else if (genreChoice == 2) {
                selectedMovies = comedyMovies;
            } else {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            
            System.out.println("\n=== Movies in this Genre ===");
            for (int i = 0; i < selectedMovies.length; i++) {
                System.out.println((i + 1) + ". " + selectedMovies[i].title);
            }
            
            System.out.print("\nEnter movie number to view details (0 to go back): ");
            int movieChoice = scanner.nextInt();
            
            if (movieChoice == 0) {
                continue; 
            }
            
          
            if (movieChoice >= 1 && movieChoice <= selectedMovies.length) {
                selectedMovies[movieChoice - 1].displayDetails();
                System.out.print("\nDo you want to watch this movie? (1 for Yes, 2 for No): ");
                int watchChoice = scanner.nextInt();
                if (watchChoice == 1) {
                    System.out.println("Enjoy watching the movie!");
                } else {
                    System.out.println("Maybe next time!");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}
