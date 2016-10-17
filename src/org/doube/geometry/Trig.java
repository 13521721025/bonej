package org.doube.geometry;

/**
 * Provides simple trigonometric calculations
 *
 * @author Michael Doube
 */
public class Trig {

	/**
	 * <p>
	 * Calculate the distance between 2 3D points p and q using Pythagoras'
	 * theorem, <i>a</i><sup>2</sup> = <i>b</i><sup>2</sup> + <i>c</i>
	 * <sup>2</sup>
	 * </p>
	 *
	 * @param p
	 *            a 3 element array
	 * @param q
	 *            another 3 element array
	 * @return distance between <i>p</i> and <i>q</i>
	 */
	public static double distance3D(final double[] p, final double[] q) {
		return distance3D(p[0], p[1], p[2], q[0], q[1], q[2]);
	}

	/**
	 * <p>
	 * Calculate the distance between 2 3D points <i>p</i>(x, y, z) and <i>q</i>
	 * (x, y, z) using Pythagoras' theorem
	 * </p>
	 *
	 * @param px
	 *            x-coordinate of first point
	 * @param py
	 *            y-coordinate of first point
	 * @param pz
	 *            z-coordinate of first point
	 * @param qx
	 *            x-coordinate of second point
	 * @param qy
	 *            y-coordinate of second point
	 * @param qz
	 *            z-coordinate of second point
	 * @return
	 */
	public static double distance3D(final double px, final double py, final double pz, final double qx, final double qy,
			final double qz) {
		return distance3D(px - qx, py - qy, pz - qz);
	}

	/**
	 * <p>
	 * Calculate the distance to the origin, (0,0,0). Given 3 orthogonal
	 * vectors, calculates the vector sum
	 * </p>
	 *
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static double distance3D(final double x, final double y, final double z) {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public static double distance3D(final double[] v) {
		return distance3D(v[0], v[1], v[2]);
	}

	/**
	 * Caculate the angle between two vectors joined at their tails at the point
	 * (xv, yv, zv)
	 *
	 * @param x0
	 *            x-coordinate of the head of vector 0
	 * @param y0
	 *            y-coordinate of the head of vector 0
	 * @param z0
	 *            z-coordinate of the head of vector 0
	 * @param x1
	 *            x-coordinate of the head of vector 1
	 * @param y1
	 *            y-coordinate of the head of vector 1
	 * @param z1
	 *            z-coordinate of the head of vector 1
	 * @param xv
	 *            x-coordinate of the mutual tail point
	 * @param yv
	 *            y-coordinate of the mutual tail point
	 * @param zv
	 *            z-coordinate of the mutual tail point
	 * @return angle formed by 0-V-1
	 */
	public static double angle3D(double x0, double y0, double z0, double x1, double y1, double z1, final double xv,
			final double yv, final double zv) {

		double xa = x0 - xv;
		double ya = y0 - yv;
		double za = z0 - zv;
		double xb = x1 - xv;
		double yb = y1 - yv;
		double zb = z1 - zv;

		final double dot = xa * xb + ya * yb + za * zb;
		final double da = distance3D(xa, ya, za);
		final double db = distance3D(xb, yb, zb);

		double cosTheta = dot / (da * db);

		if (Double.compare(cosTheta, -1.0) < 0) {
			cosTheta = -1.0;
		} else if (Double.compare(cosTheta, 1.0) > 0) {
			cosTheta = 1.0;
		}

		return Math.acos(cosTheta);
	}

}
