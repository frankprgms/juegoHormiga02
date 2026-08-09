package prueba2;

public class RecorteSprite {

    private final float uInicio;
    private final float uFin;
    private final float vInicio;
    private final float vFin;

    public RecorteSprite(float uInicio, float uFin, float vInicio, float vFin) {
        this.uInicio = uInicio;
        this.uFin = uFin;
        this.vInicio = vInicio;
        this.vFin = vFin;
    }

    public float getuInicio() { return uInicio; }
    public float getuFin() { return uFin; }
    public float getvInicio() { return vInicio; }
    public float getvFin() { return vFin; }
}

        