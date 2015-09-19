## Delaunay Triangulator Library
A simple and lean Java implementation of an incremental 2D Delaunay triangulation algorithm.
### How to use
The code below shows how to use the `DelaunayTriangulator` class in order to triangulate a given set of points:
```java
try {
    Vector<Vector2D> pointSet = loadPointSet("data/normal-formation.conf");
    
    delaunayTriangulator = new DelaunayTriangulator(pointSet);
    delaunayTriangulator.triangulate();
    
    Vector<Triangle2D> triangleSoup = delaunayTriangulator.getTriangles();
    
} catch (NotEnoughPointsException e) {
}
```
The constructor throws a `NotEnoughPointsException` if it is invoked with less than three points.
### How to build
The Delaunay triangulator library uses Gradle as a build tool and makes use of its multi project build capabilities. Each subproject contains its own build file and can be build separately. Hence you can build only the part you want. For example if you just want to build the library, then it is sufficient to locate into the project's root directory and type the following command into your shell:
```bash
gradle library:build
```
This will cause Gradle to build the `DelaunayTriangulator-1.0.0.jar` library artifact in `library/build/libs/`. If you just want to build the example, then type the following into your shell:
```bash
gradle example:build
```
This causes Gradle to build the `example.zip` and `example.tar` distribution artifacts in `example/build/distributions/`. In case you want to build the whole multi project then type:
```bash
gradle build
```
### Dependencies
The Delaunay triangulation library itself does not have any dependencies; however, the example subproject uses JOGL 2.3.1 for rendering a triangulated point set using OpenGL. See [http://jogamp.org/](http://jogamp.org/) for further details on JOGL.
### License
```
The MIT License (MIT)

Copyright (c) 2015 Johannes Diemke

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
### History
##### 2015-09-18 / Release 1.0.0
-   Minor refactoring
-   Created Gradle build files
-   Initial commit to GitHub

##### 2010-08-01 / Release 0.0.0
-   Initial implementation of the Delaunay triangulation algorithm