public enum Direction {
    N, E, S, W;

    public Direction turnLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalArgumentException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case N: return "North";
            case E: return "East";
            case S: return "South";
            case W: return "West";
            default: throw new IllegalArgumentException();
        }
    }
}
