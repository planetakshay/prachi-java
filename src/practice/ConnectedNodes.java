package practice;

/**
 * Find if a source node and a target nodes are connected in a directed graph.
 * The following example uses adjacency matrix to display the connection between
 * two Nodes/Vertices. The matrix cell will have 0 if the nodes are not
 * connected. The cell will have 1 if the nodes are connected.
 * 
 * The method returns true if the nodes are connected directly or indirectly.
 * False otherwise
 * 
 * HP on-site
 * 
 * @author Prachi
 * 
 */
public class ConnectedNodes {

	public static void main(String args[]) {

		byte[][] connection = new byte[][] { { 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0 } };

		ConnectedNodes nodes = new ConnectedNodes();

		System.out.println("Nodes are connected: "
				+ nodes.isConnected(connection, 1, 5));
	}

	public boolean isConnected(byte[][] array, int source, int target) {

		if (array[source][target] == 1) {

			return true;
		} else {

			for (int i = 0; i < array.length; i++) {

				if (array[source][i] == 1) {

					return isConnected(array, i, target);
				}
			}
		}

		return false;
	}
}
