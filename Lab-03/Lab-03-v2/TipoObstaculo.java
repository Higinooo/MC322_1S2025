public enum TipoObstaculo {
    MURO(3, 5, true),
    PREDIO(10,9, true),
    BURACO(0,1, true),
    OUTRO(-1,0, false);



    private final int alturaPadrao;
    private final int resistencia;
    private final boolean bloqueiaPassagem;
   

    TipoObstaculo(int alturaPadrao, int resistencia, boolean bloqueiaPassagem){
        this.alturaPadrao = alturaPadrao;
        this.resistencia = resistencia;
        this.bloqueiaPassagem = bloqueiaPassagem;
    }
    public int getAlturaPadrao () {
        return alturaPadrao;
    }

    public int getResistenciaTipo () {
        return resistencia;
    }

    public boolean isBloqueiaPassagem () {
        return bloqueiaPassagem;
    }
}
