package Model;

    public class DirectionalLight implements ILight {
        private Color color;
        private Vector direction;

        public DirectionalLight(Color color, Vector direction) {
            this.color = color;
            this.direction = direction;
        }

        @Override
        public Color getColor() {
            return color;
        }

        public Vector getPosition() {

            return direction;
        }
    }