package leetcode.tree.dfs;

import java.util.*;

/**
 * Created by joshua.chi on 6/19/17.
 */
public class MovieRating {
    private PriorityQueue<Movie> queue;

    private int capacity;
    private boolean hasCapacity;
    public MovieRating (int c) {
        this.capacity = c;
        this.hasCapacity = true;
        queue = new PriorityQueue<Movie>(new Comparator<Movie>() {
            public int compare(Movie m1, Movie m2) {
                return m2.rating > m1.rating? 1: -1;
            }
        });
    }

    public MovieRating () {
        this.hasCapacity = false;
        queue = new PriorityQueue<Movie>(new Comparator<Movie>() {
            public int compare(Movie m1, Movie m2) {
                return m2.rating > m1.rating? 1: -1;
            }
        });
    }

    public void dfs (Movie root, Queue<Movie> queue, HashSet<Movie> visited) {
        if (visited.contains(root)) {
            return;
        }
        if (root != null) {
            if (isFull()) {
                removeLast();
            }
            queue.add(root);
            visited.add(root);
            List<Movie> next = root.similarMovies;
            for (Movie m: next) {
                dfs(m, queue, visited);
            }
        }
    }

    public List<Movie> getSimilariesTopN(int n) {
        int count = 0;
        List<Movie> l = new ArrayList<>();
        Iterator<Movie> i = queue.iterator();
        while (count < n && i.hasNext()) {
            l.add((Movie) i.next());
            count++;
        }
        return l;
    }

    public boolean isFull() {
        if (hasCapacity) {
            return queue.size() >= capacity;
        }
        return false;
    }

    public void removeLast() {
        queue.poll();
    }

    public static class Movie {
        private int movieId; //0-3
        private float rating;

        private List<Movie> similarMovies;

        public Movie (int movieId, float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<>();
        }

        public void addSimilarMovie(Movie m) {
            similarMovies.add(m);
        }

    }

    /*
     * Implement a function to return top rated movies in the network of movies
     * reachable from the current movie
     * eg:            A(Rating 1.2)
     *               /   \
     *            B(2.4)  C(3.6)
     *              \     /
     *               D(4.8)
     * In the above example edges represent similarity and the number is rating.
     * getMovieRecommendations(A,2)should return C and D (sorting order doesn't matter so it can also return D and C)
     * getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
     * getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter,
     *                            return the highest  rated.
     *
     *     @param movie
     *     @param numTopRatedSimilarMovies
     *                      number of movies we want to return
     *     @return List of top rated similar movies
     */
    public List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
        HashSet<Movie> visited = new HashSet<>();
        dfs(movie, queue, visited);
        return getSimilariesTopN(numTopRatedSimilarMovies);
    }

    public static void main(String[] args) {
        MovieRating movieRating = new MovieRating();
        Movie a = new Movie(1, 1.2f);
        Movie b = new Movie(2, 2.4f);
        Movie c = new Movie(3, 3.6f);
        Movie d = new Movie(4, 4.8f);
        a.addSimilarMovie(b);
        a.addSimilarMovie(c);
        b.addSimilarMovie(d);
        c.addSimilarMovie(d);

        List<Movie> l = movieRating.getMovieRecommendations(a, 1);
        for (Movie m: l) {
            System.out.println(m.movieId);
        }
    }
}
