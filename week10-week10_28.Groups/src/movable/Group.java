package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> members = new ArrayList<Movable>();

    public void addToGroup(Movable member){
        members.add(member);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable member : members){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable member:members){
            member.move(dx, dy);
        }
    }
}
