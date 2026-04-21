class Solution {
    record Pair(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pair = new Pair[n];

        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(pair, (a, b) -> b.position() - a.position());

        double lastTime = -1;
        int fleet = 0;
        for (int i = 0; i < n; i++) {
            double time = (double)(target - pair[i].position()) / pair[i].speed();

            if (time > lastTime) {
                fleet++;
                lastTime = time;
            }
        }
        return fleet;
    }
}
