public class Pair implements Comparable<Pair>{
    Integer dist;
    Integer index;
    public Pair(Integer distance, Integer i){
        dist = distance;
        index = i;
    }

    @Override
    public int compareTo(Pair o) {
        return this.dist.compareTo(o.dist);
    }
}
