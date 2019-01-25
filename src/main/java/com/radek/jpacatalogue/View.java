package com.radek.jpacatalogue;

import java.time.LocalDate;
import java.util.List;

class View {
    private ViewAnswers answer;
    private final String backTitle = "[9] Back to main menu";
    private final String borderLine = "--------------------------------------------------------------------------";

    View() {
        answer = new ViewAnswers();
    }

    /*
        Main menu view----------------------------------------------------
     */
    public int displayMainMenuView() {
        System.out.println("\n\t" + "MOVIES LIBRARY MENU" + "\n");
        System.out.println("\t\t" + "[1] Show movies list");
        System.out.println("\t\t" + "[2] Add new movie");
        System.out.println("\t\t" + "[3] Remove movie");
        System.out.println("\t\t" + "[4] Movies ratings");
        System.out.println("\t\t" + "[5] Search movie");
        System.out.println("\t\t" + "[6] Edit movie");
        System.out.println("\t\t" + "[7] Add comment");
        System.out.println("\t\t" + "[8] Show comment");
        System.out.println("\n\t\t" + "[0] EXIT");
        return answer.mainMenuChoice();
    }

    /*
      Movies list view------------------------------------------------------
   */
    public void displayMoviesList(List<Movie> list) {
        System.out.println(borderLine);
        System.out.println("\n\t" + "MOVIES LIST" + "\n");
        System.out.println(list);
        System.out.println("\t" + backTitle + "\n");
        answer.checkIfBack();
    }

    /*
       Add movie view------------------------------------------------------------
    */
    public String displayAddTitle() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "ADD MOVIE TO LIST" + "\n");
        System.out.println("Type in the title of movie:");
        return answer.stringAnswer();
    }

    public String displayAddYear() {
        System.out.println("\n" + "Type in a year of production:");
        return answer.yearInput();
    }

    public boolean displayAddConfirmation() {
        System.out.println("\n" + "Do you want to addUpdMovie this movie Y/N");
        return answer.selectYesNo();
    }

    /*
    Edit movie
     */

    public void choiceMovieToEdit() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "EDIT MOVIE" + "\n");
    }

    public String enterEditTitle(Movie movie) {
        System.out.println("You are editing " + movie);
        System.out.println("Type in the title of movie:");
        return answer.stringAnswer();
    }

    public String displayEditYear() {
        System.out.println("\n" + "Type in a year of production:");
        return answer.yearInput();
    }

    public boolean displayEditConfirmation() {
        System.out.println("\n" + "Do you want to addUpdMovie this movie Y/N");
        return answer.selectYesNo();
    }


    /*
    Remove movie view-----------------------------------------------------------------------
     */
    public void displayRemove() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "REMOVE MOVIE FROM LIST" + "\n");
    }

    public boolean displayRemoveConfirm(Movie movie) {
        System.out.println(movie);
        System.out.println("Are you sure you want to delete this movie? Y/N");
        return answer.selectYesNo();
    }

    /*
    Display movie rating
    */
    public void displayChoiceToRatings() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "MOVIES RATING" + "\n");
    }

    public int displayRatingMovie(Movie movie) {
        System.out.println(movie);
        System.out.println("Movie ratings from 1 to 7.");
        return answer.checkRatings();
    }

    /*
    Display search menu
     */
    public int displaySearchMenu() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "SEARCH MOVIE" + "\n");
        System.out.println("\t\t" + "1. Search by title.");
        System.out.println("\t\t" + "2. Search by rate.");
        System.out.println("\t\t" + "3. Search by date of adding.");
        return answer.searchChoice();
    }

    //Search by title
    public String searchByTitle() {
        System.out.println("Type in title of movie.");
        return answer.stringAnswer();
    }

    //Display movies founded by title.
    public void displaySearchByTitle(List<Movie> list, String title) {
        System.out.println(borderLine);
        System.out.println("\n\t" + "Founded movies with words: " + "' " + title + " '");
        System.out.println("\n" + list);
        System.out.println("\t" + backTitle + "\n");
        answer.checkIfBack();
    }

    //Search by date
    public LocalDate searchByDate() {
        System.out.println("Type in date of add to search (yyyyMMdd).");
        return answer.checkIfDateIsCorrect();
    }

    //Display movies founded by date.
    public void displaySearchByDate(List<Movie> list, LocalDate date) {
        System.out.println(borderLine);
        System.out.println("\n\t" + "Founded movies added on: " + "' " + date + " '");
        System.out.println("\n" + list);
        System.out.println("\t" + backTitle + "\n");
        answer.checkIfBack();
    }

    //Search by rate
    public int searchByRate() {
        System.out.println("Type in rate of movie.");
        return answer.ifInt();
    }

    //Display movies founded by rate.
    public void displaySearchByRate(List<Movie> list, double rate) {
        int intRate = (int) rate;
        System.out.println(borderLine);
        System.out.println("\n\t" + "Founded movies with rating: " + "' " + intRate + " '");
        System.out.println("\n" + list);
        System.out.println("\t" + backTitle + "\n");
        answer.checkIfBack();
    }

    /*
    Enter movie comments
    */
    public void displayChoiceToComment() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "MOVIES COMMENT" + "\n");
    }

    public String displayEnterComment(Movie movie) {
        System.out.println("Enter a comment for the movie: " + movie);
        return answer.stringAnswer();
    }

    /*
    Show movie comments
    */
    public void displayShowComment() {
        System.out.println(borderLine);
        System.out.println("\n\t" + "SHOW COMMENTS" + "\n");
    }

    public void displayComments(Movie movie) {
        System.out.print("Here are the comments for the movie " + movie);
        List<String> comm = movie.getCommentsList();
        for (String com : comm) {
            System.out.println(" ");
            System.out.println("*** " + com + " ***");
        }
        System.out.println(" ");
        System.out.println("\t" + backTitle + "\n");
        answer.checkIfBack();
    }

    public void idNotFounded() {
        System.out.print("ID not founded! Try again." + "\n");
    }

    public int enterId() {
        System.out.print("Enter ID of movie: ");
        return answer.ifInt();
    }
}
