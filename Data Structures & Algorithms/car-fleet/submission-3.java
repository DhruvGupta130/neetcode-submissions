class Solution {
    record Pair(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pair = new Pair[n];

        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(pair, (a, b) -> b.position() - a.position());

        Deque<Double> stack = new ArrayDeque<>();
        int fleet = 0;
        for (int i = 0; i < n; i++) {
            int pos = pair[i].position();
            int sp = pair[i].speed();
            double time = (double)(target - pos) / sp;

            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);   
                fleet++;
            } 
        }
        return fleet;
    }
}
