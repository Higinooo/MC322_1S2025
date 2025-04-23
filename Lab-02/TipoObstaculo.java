public enum TipoObstaculo {
    MURO(3, true),
    PREDIO(10, true),
    BURACO(0, true),
    OUTRO(-1, false);



    private final int alturaPadrao;
    private final boolean bloqueiaPassagem;

    TipoObstaculo(int alturaPadrao, boolean bloqueiaPassagem){
        this.alturaPadrao = alturaPadrao;
        this.bloqueiaPassagem = bloqueiaPassagem;
    }
    public int getAlturaPadrao () {
        return alturaPadrao;
    }

    public boolean isBloqueiaPassagem () {
        return bloqueiaPassagem;
    }
}
