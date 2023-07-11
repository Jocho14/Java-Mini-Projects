class SnailThread extends Thread {
    private Snail snail;
    private LeafPanel leafPanel;

    public SnailThread(Snail snail, LeafPanel leafPanel, int t, int v) {
        this.snail = snail;
        this.leafPanel = leafPanel;
        this.snail.setT(t);
        this.snail.setV(v);
    }

    @Override
    public void run() {
        boolean shouldRun = true;
        while (shouldRun) {
            synchronized (SnailThread.class) {
                snail.move();
                snail.eat();
            }
            leafPanel.repaint();
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                shouldRun = false;
                e.printStackTrace();
            }
        }
    }
}
