var angularSpeed = 0.2; 
var lastTime = 0;
 
//Executa esta função a cada frame
function animate() {
  var time = (new Date()).getTime();
  var timeDiff = time - lastTime;
  var angleChange = angularSpeed * timeDiff * 2 * Math.PI / 1000;
  cube.rotation.y += angleChange;
  lastTime = time;

  renderer.render(scene, camera);

  requestAnimationFrame(function(){
    animate();
  });
}
 
// renderer
var c = document.getElementById('cenas');

var renderer = new THREE.WebGLRenderer();
renderer.setSize(500, 500);
c.appendChild(renderer.domElement);
 
// camara
var camera = new THREE.PerspectiveCamera(45, 500 / 500, 1, 1000);
camera.position.z = 500;
 
// cena
var scene = new THREE.Scene();
      
// material
var material = new THREE.MeshLambertMaterial({map: THREE.ImageUtils.loadTexture('LernaeanHydra.jpg')});
                
// cubo
var cube = new THREE.Mesh(new THREE.CubeGeometry(200, 200, 200), material);
cube.overdraw = true;
cube.rotation.x = Math.PI * 0.1;
scene.add(cube);
      
// luz ambiente (muito subtil)
var ambientLight = new THREE.AmbientLight(0xbbbbbb);
scene.add(ambientLight);
      
//Luz direccional
var directionalLight = new THREE.DirectionalLight(0xffffff);
directionalLight.position.set(1, 1, 1).normalize();
scene.add(directionalLight);
 
animate();