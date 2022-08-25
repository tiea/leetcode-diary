import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int length = restaurants.length;
        List<Restaurant> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] restaurant = restaurants[i];
            if (veganFriendly == 1 && restaurant[2] != 1) {
                continue;
            }
            if (maxPrice > 0 && maxPrice < restaurant[3]) {
                continue;
            }
            if (maxDistance > 0 && maxDistance < restaurant[4]) {
                continue;
            }
            list.add(new Restaurant(restaurant[0], restaurant[1]));
        }
        list.sort(new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant l, Restaurant r) {
                if (l.rating > r.rating) {
                    return -1;
                } else if (l.rating < r.rating) {
                    return 1;
                } else {
                    return r.id - l.id ;
                }
            }
        });
        return list.stream().map(item -> item.id).collect(Collectors.toList());
    }

    class Restaurant {
        int id;
        int rating;
        public Restaurant(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }
}