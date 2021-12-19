package isp.lab3.exercise3;

public class Vehicle {
        private String _model;
        private String _type;
        private int _speed;
        private char _fuelType;

        private static int nrVehiclesCreated;

        public Vehicle(String model, String type, int speed, char fuelType) {
            _model = model;
            _type = type;
            _speed = speed;
            _fuelType = fuelType;

            nrVehiclesCreated++;

        }

        public static int GetNumberOfVehiclesCreated(){
            return nrVehiclesCreated;
        }

        public String getType() {
            return _type;
        }

        public int getSpeed() {
            return _speed;
        }

        public char getFuelType() {
            return _fuelType;
        }

        public String getModel() {
            return _model;
        }

        public void set_fuelType(char _fuelType) {
            this._fuelType = _fuelType;
        }

        public void set_model(String _model) {
            this._model = _model;
        }

        public void set_speed(int _speed) {
            this._speed = _speed;
        }

        public void set_type(String _type) {
            this._type = _type;
        }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }


        Vehicle vehicleBeeingTested = (Vehicle) o;

        return this._model.equals( vehicleBeeingTested._model )  && this._type.equals( vehicleBeeingTested._type )
                && this._speed == vehicleBeeingTested._speed && this._fuelType == vehicleBeeingTested._fuelType;
    }
    @Override
        public String toString() {
            return _model + "(" + _type + ")" + " speed " + _speed + " fuel type " + _fuelType;
        }

}
