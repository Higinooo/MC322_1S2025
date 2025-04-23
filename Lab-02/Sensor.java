public abstract class Sensor {
    protected double raio;

    public Sensor(double raio){
        this.raio = raio;
    }

    public abstract void monitorar(Ambiente ambiente, int x, int y, int z); // x, y, z do robo
}
