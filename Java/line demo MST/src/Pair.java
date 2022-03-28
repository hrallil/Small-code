class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;
    public Pair(Integer dist, Integer i) {
        this.distance = dist;
        this.index = i;
    }
    public Integer getDistance() {
        return distance;
    }

    public Integer getIndex() {
        return index;
    }
    @Override
    public int compareTo(Pair o) {
        return this.distance.compareTo((o.distance));
    }
}
