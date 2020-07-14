public class Day14 {
    public double angleClock(int hour, int minutes) {
        double minutes_percentage = minutes / 60.0;
        double real_hour = (hour + minutes_percentage) % 12;
        double minutes_angle = minutes * 360 / 60.0;
        double hour_angle = real_hour * 360 / 12;
        double bigger_angle = Math.max(hour_angle, minutes_angle);
        double smaller_angle = Math.min(hour_angle, minutes_angle);
        return Math.min(
            bigger_angle - smaller_angle,
            smaller_angle + 360 - bigger_angle
        );
    }
}
