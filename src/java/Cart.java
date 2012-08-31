
import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meherzad
 */
public class Cart {

    Hashtable<Integer, Integer> cart = new Hashtable<Integer, Integer>();

    void addToCart(int prodId) {
        if (cart.containsKey(prodId)) {
            int quant = cart.get(prodId);
            quant++;
            cart.put(prodId, quant);
        } else {
            cart.put(prodId, 1);
        }

    }

    int cartSize() {
        return cart.size();
    }

    Hashtable<Integer, Integer> sendCart() {
        return cart;
    }

    void emptyCart() {
        cart.clear();
    }
}
