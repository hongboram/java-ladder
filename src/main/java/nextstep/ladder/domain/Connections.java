package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Connections {
    private final List<Connection> connections;

    public Connections(List<Connection> connections) {
        this.connections = new ArrayList<>(connections);
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connections that = (Connections) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }

    public boolean isConnected(int widthPoint) {
        return connections.get(widthPoint)
                .isConnected();
    }
}