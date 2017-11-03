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

		friend ostream &operator << (ostream &output, Point &that) {
			return output << "(" << that._x << ", " << that._y << ")";
		}

		void print_self() {
			cout << "(" << this->_x << ", " << this->_y << ")" << endl;
		}

	private:
		Point(const float x, const float y) : _x(x), _y(y) { };
		float _x;
		float _y;
};

int main() {
	Point p1 = Point::cartesian(5.8, 1.2);
	Point p2 = Point::polar(5.7, 1.2);

	cout << "p1 = " << p1 << endl;
	cout << "p2 = " << p2 << endl;

	return 0;
}