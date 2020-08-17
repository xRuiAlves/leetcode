public class Day17 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int i = 0;

        while (true) {
            people[i % num_people] += (i + 1);
            candies -= (i + 1);
            
            if (candies <= 0) {
                people[i % num_people] -=- candies;
                break;
            }
            ++i;
        }
        
        return people;
    }
}
