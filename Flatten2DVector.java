public class Vector2D {
    int list;
    int index;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        list = 0;
        index = 0;
        this.vec2d = vec2d;
    }

    public int next() {
        int rst = vec2d.get(list).get(index);
        index++;
        if (index == vec2d.get(list).size()) {
            list++;
            index = 0;
        } 
        return rst;
    }

    public boolean hasNext() {
        while (list < vec2d.size() && vec2d.get(list).size() == 0) {
            list++;
        }
        return list < vec2d.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */