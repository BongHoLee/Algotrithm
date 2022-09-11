package Programmers.level3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 속한 노래가 많이 재생된 '장르' 먼저 수록 장르 내에서 많이 재생된 '노래' 수록
 * <p>
 * -> 결국 '그룹핑'과 '정렬'이 관건. -> 정렬 조건이 '그룹', '개별'로 이어진다는 부분에 집중
 */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        BestAlbum bestAlbum = new BestAlbum();
        int[] solution = bestAlbum.solution(genres, plays);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] genres, int[] plays) {
        AlbumRecorder recorder = new AlbumRecorder();
        for (int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            int playsCount = plays[i];
            recorder.addAlbum(new Album(genreName, playsCount, i));
        }

        return recorder.record();
    }
}

class AlbumRecorder {
    private final Map<String, Genre> records = new HashMap<>();

    public void addAlbum(Album album) {
        records.computeIfAbsent(album.getGenreName(), Genre::new).addAlbum(album);
    }

    public int[] record() {
        return records.values().stream()
                .sorted()
                .collect(Collectors.toList())
                .stream()
                .map(Genre::getOrderedAlbums)
                .flatMapToInt(albums -> albums.stream().mapToInt(Album::getPosition).limit(2))
                .toArray();

    }
}

class Genre implements Comparable<Genre> {
    private final String genreName;
    private int totalPlayCount = 0;
    private final List<Album> albums = new ArrayList<>();

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public void addAlbum(Album album) {
        totalPlayCount += album.getPlaysCount();
        albums.add(album);
    }

    public List<Album> getOrderedAlbums() {
        Collections.sort(albums);
        return albums;
    }

    @Override
    public int compareTo(Genre other) {
        return other.totalPlayCount > this.totalPlayCount ? 1 : -1;
    }
}

class Album implements Comparable<Album> {
    private final String genreName;
    private final int playsCount;
    private final int position;

    public Album(String genreName, int playsCount, int position) {
        this.genreName = genreName;
        this.playsCount = playsCount;
        this.position = position;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getPlaysCount() {
        return playsCount;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Album other) {
        if (other.getPlaysCount() > this.playsCount) {
            return 1;
        } else if (other.playsCount < this.playsCount) {
            return -1;
        } else {
            return other.getPosition() > this.position ? -1 : 1;
        }
    }
}



