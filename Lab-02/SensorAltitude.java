public class SensorAltitude extends Sensor {

    public SensorAltitude(double raio) {
        super(raio);
    }

    public void monitorar(Ambiente ambiente, int x, int y, int z) {
        System.out.println("Sensor de altitude: altitude atual = " + z);
        if (z >= ambiente.getProfundidade()) {
            System.out.println("Atenção: altitude máxima do ambiente alcançada!");
        }
    }
}
