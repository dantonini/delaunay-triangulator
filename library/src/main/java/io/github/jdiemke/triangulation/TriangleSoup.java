package io.github.jdiemke.triangulation;

import java.util.Arrays;
import java.util.Vector;

/**
 * Triangle soup class implementation.
 * 
 * @author Johannes Diemke
 */
class TriangleSoup {

    private Vector<Triangle2D> triangleSoup;

    /**
     * Constructor of the triangle soup class used to create a new triangle soup
     * instance.
     */
    public TriangleSoup() {
	this.triangleSoup = new Vector<Triangle2D>();
    }

    /**
     * Adds a triangle to this triangle soup.
     * 
     * @param triangle
     *            The triangle to be added to this triangle soup
     */
    public void add(Triangle2D triangle) {
	this.triangleSoup.add(triangle);
    }

    /**
     * Removes a triangle from this triangle soup.
     * 
     * @param triangle
     *            The triangle to be removed from this triangle soup
     */
    public void remove(Triangle2D triangle) {
	this.triangleSoup.remove(triangle);
    }

    /**
     * Returns the triangles from this triangle soup.
     * 
     * @return The triangles from this triangle soup
     */
    public Vector<Triangle2D> getTriangles() {
	return this.triangleSoup;
    }

    /**
     * Returns the triangle from this triangle soup that contains the specified
     * point or null if no triangle from the triangle soup contains the point.
     * 
     * @param point
     *            The point
     * @return Returns the triangle from this triangle soup that contains the
     *         specified point or null
     */
    public Triangle2D findContainingTriangle(Vector2D point) {
	for (Triangle2D triangle : triangleSoup) {
	    if (triangle.contains(point)) {
		return triangle;
	    }
	}
	return null;
    }

    /**
     * Returns the neighbor triangle of the specified triangle sharing the same
     * edge as specified. If no neighbor sharing the same edge exists null is
     * returned.
     * 
     * @param triangle
     *            The triangle
     * @param edge
     *            The edge
     * @return The triangles neighbor triangle sharing the same edge or null if
     *         no triangle exists
     */
    public Triangle2D findNeighbour(Triangle2D triangle, Edge2D edge) {
	for (Triangle2D triangleFromSoup : triangleSoup) {
	    if (triangleFromSoup.isNeighbour(edge) && triangleFromSoup != triangle) {
		return triangleFromSoup;
	    }
	}
	return null;
    }

    /**
     * Returns one of the possible triangles sharing the specified edge. Based
     * on the ordering of the triangles in this triangle soup the returned
     * triangle may differ. To find the other triangle that shares this edge use
     * the {@link findNeighbour(Triangle2D triangle, Edge2D edge)} method.
     * 
     * @param edge
     *            The edge
     * @return Returns one triangle that shares the specified edge
     */
    public Triangle2D findOneTriangleSharing(Edge2D edge) {
	for (Triangle2D triangle : triangleSoup) {
	    if (triangle.isNeighbour(edge)) {
		return triangle;
	    }
	}
	return null;
    }

    /**
     * Returns the edge from the triangle soup nearest to the specified point.
     * 
     * @param point
     *            The point
     * @return The edge from the triangle soup nearest to the specified point
     */
    public Edge2D findNearestEdge(Vector2D point) {
	Vector<EdgeDistancePack> edgeVector = new Vector<EdgeDistancePack>();

	for (Triangle2D triangle : triangleSoup) {
	    edgeVector.add(triangle.findNearestEdge(point));
	}

	EdgeDistancePack[] edgeDistancePacks = new EdgeDistancePack[edgeVector.size()];
	edgeVector.toArray(edgeDistancePacks);

	Arrays.sort(edgeDistancePacks);
	return edgeDistancePacks[0].edge;
    }

    /**
     * Removes all triangles from this triangle soup that contain the specified
     * vertex.
     * 
     * @param vertex
     *            The vertex
     */
    public void removeTrianglesUsing(Vector2D vertex) {
	Vector<Triangle2D> trianglesToBeRemoved = new Vector<Triangle2D>();

	for (Triangle2D triangle : triangleSoup) {
	    if (triangle.hasVertex(vertex)) {
		trianglesToBeRemoved.add(triangle);
	    }
	}

	triangleSoup.removeAll(trianglesToBeRemoved);
    }

}