#include <iostream>
#include <cmath>

using namespace std;

class Point {
	public:
		Point(void) : _x(0.0), _y(0.0) { };

		static Point cartesian(const float x, const float y) {
			return Point(x, y);
		}

		static Point polar(const float rho, const float theta) {
			return Point(rho*cos(theta), rho*sin(theta));
		}

		friend istream &operator >> (istream &input, Point &that) {
			return input >> that._x >> that._y;
		}

		friend ostream &operator << (ostream &output, Point &that) {
			return output << "(" << that._x << ", " << that._y << ")";
		}

	private:
		Point(const float x, const float y) : _x(x), _y(y) { };
		float _x;
		float _y;
};

int main() {
	Point p;

	cout << "Enter a new point x y: ";
	cin >> p;
	cout << "p = " << p << endl;

	return 0;
}