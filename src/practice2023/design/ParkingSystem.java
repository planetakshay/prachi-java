package practice2023.design;

/**
 * https://leetcode.com/problems/design-parking-system/
 */
public class ParkingSystem {
    boolean[] big;
    boolean[] medium;
    boolean[] small;

    public ParkingSystem() {
    }

    public ParkingSystem(int big, int medium, int small) {
        this.big = new boolean[big];
        this.medium = new boolean[medium];
        this.small = new boolean[small];
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            for (int i = 0; i < big.length; i++) {
                if (!big[i]) {
                    big[i] = true;
                    return true;
                }
            }
        } else if (carType == 2) {
            for (int i = 0; i < medium.length; i++) {
                if (!medium[i]) {
                    medium[i] = true;
                    return true;
                }
            }
        } else if (carType == 3) {
            for (int i = 0; i < small.length; i++) {
                if (!small[i]) {
                    small[i] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] getBig() {
        return big;
    }

    public void setBig(boolean[] big) {
        this.big = big;
    }

    public boolean[] getMedium() {
        return medium;
    }

    public void setMedium(boolean[] medium) {
        this.medium = medium;
    }

    public boolean[] getSmall() {
        return small;
    }

    public void setSmall(boolean[] small) {
        this.small = small;
    }
}


// Best and clean solution

/*


class ParkingSystem {
    private static int big;
    private static int medium;
    private static int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean result = true;
        switch(carType) {
            case 1:
                result = big > 0;
                big--;
                break;
            case 2:
                result = medium > 0;
                medium--;
                break;
            default:
                result = small > 0;
                small--;
        }

        return result;
    }
}
 */