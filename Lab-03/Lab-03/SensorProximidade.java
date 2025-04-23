public class SensorProximidade extends Sensor {

    public SensorProximidade(double raio) {
        super(raio);
    }

    public void monitorar(Ambiente ambiente, int x, int y, int z) {
        boolean encontrou = false;
        int alcance = (int) Math.ceil(raio);

        System.out.println("Sensor de proximidade: escaneando área em torno de (" + x + ", " + y + ")");

        for (int i = x - alcance; i <= x + alcance; i++) {
            for (int j = y - alcance; j <= y + alcance; j++) {
                if (ambiente.dentroDosLimites(i, j) && ambiente.temObstaculoEm(i, j)) {
                    System.out.println("Obstáculo detectado em (" + i + ", " + j + ")");
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum obstáculo nas proximidades.");
        }
    }
}

