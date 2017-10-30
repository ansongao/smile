<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好!少年</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}

	html, 
	body {
		height: 100%;
		position: relative;
		width: 100%;
	}

	body {
		background: #eee;
	}

	canvas {
		background: white;
		display: block;
	}

</style>

<script type="text/javascript">
;(function(main) {
	var args = {};
	window.onload = function() {
		main(args);
	};
})(function(args) {

	'use strict';

	var Box = function(x, y, w, h, s) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.s = s;
		this.a = Math.random() * Math.PI * 2;
		this.hue = Math.random() * 360;
	};

	Box.prototype = {
		constructor: Box,
		update: function() {
			this.a += Math.random() * 0.5 - 0.25;
			this.x += Math.cos(this.a) * this.s;
			this.y += Math.sin(this.a) * this.s;
			this.hue += 5;
			if(this.x > WIDTH) this.x = 0;
			else if(this.x < 0) this.x = WIDTH;
			if(this.y > HEIGHT) this.y = 0;
			else if(this.y < 0) this.y = HEIGHT;
		},
		render: function(ctx) {
			ctx.save();
			ctx.fillStyle = 'hsla(' + this.hue + ', 100%, 50%, 1)';
			ctx.translate(this.x, this.y);
			ctx.rotate(this.a);
			ctx.fillRect(-this.w, -this.h / 2, this.w, this.h);
			ctx.restore();
		}
	};

	var Circle = function(x, y, tx, ty, r) {
		this.x = x;
		this.y = y;
		this.ox = x;
		this.oy = y;
		this.tx = tx;
		this.ty = ty;
		this.lx = x;
		this.ly = y;
		this.r = r;
		this.br = r;
		this.a = Math.random() * Math.PI * 2;
		this.sx = Math.random() * 0.5;
		this.sy = Math.random() * 0.5;
		this.o = Math.random() * 1;
		this.delay = Math.random() * 200;
		this.delayCtr = 0;
		this.hue = Math.random() * 360;
	};

	Circle.prototype = {
		constructor: Circle,
		update: function() {

			if(this.delayCtr < this.delay) {
				this.delayCtr++;
				return;
			}

			this.hue += 1;
			this.a += 0.1;

			this.lx = this.x;
			this.ly = this.y;

			if(!clickToggle) {
				this.x += (this.tx - this.x) * this.sx;
				this.y += (this.ty - this.y) * this.sy;					
			} else {
				this.x += (this.ox - this.x) * this.sx;
				this.y += (this.oy - this.y) * this.sy;										
			}


			this.r = this.br + Math.cos(this.a) * (this.br * 0.5);
		},
		render: function(ctx) {

			ctx.save();
			ctx.globalAlpha = this.o;
			ctx.fillStyle = 'hsla(' + this.hue + ', 100%, 50%, 1)';
			ctx.translate(this.x, this.y);
			ctx.beginPath();
			ctx.arc(0, 0, this.r, 0, Math.PI * 2);
			ctx.fill();
			ctx.restore();

			if(clickToggle) {
				ctx.save();
				ctx.strokeStyle = 'hsla(' + this.hue + ', 100%, 50%, 1)';
				ctx.beginPath();
				ctx.moveTo(this.lx, this.ly);
				ctx.lineTo(this.x, this.y);
				ctx.stroke();
				ctx.restore();					
			}


		}
	};

	var txtCanvas = document.createElement('canvas');
	var txtCtx = txtCanvas.getContext('2d');

	var c = document.getElementById('c');
	var ctx = c.getContext('2d');

	var WIDTH = c.width = window.innerWidth;
	var HEIGHT = c.height = window.innerHeight;
	var imgData = null;
	var idx = null;
	var skip = 4;
	var circles = [];
	var circle = null;
	var a = null;
	var clickToggle = false;
	var boxList = [];
	var box = null;

	txtCanvas.width = WIDTH;
	txtCanvas.height = HEIGHT;

	txtCtx.font = 'bold 70px Sans-serif';
	txtCtx.textAlign = 'center';
	txtCtx.baseline = 'middle';
	txtCtx.fillText('你 好 无 聊', WIDTH / 2, HEIGHT / 2);

	ctx.font = 'bold 12px Monospace';
	ctx.textAlign = 'center';
	ctx.baseline = 'middle';

	imgData = txtCtx.getImageData(0, 0, WIDTH, HEIGHT).data;

	for(var y = 0; y < HEIGHT; y += skip) {
		for(var x = 0; x < WIDTH; x += skip) {
			idx = (x + y * WIDTH) * 4 - 1;
			if(imgData[idx] > 0) {
				a = Math.PI * 2 * Math.random();
				circle = new Circle(
					WIDTH / 2 + Math.cos(a) * WIDTH,
					HEIGHT / 2 + Math.sin(a) * WIDTH,
					x, 
					y,
					Math.random() * 4
				);
				circles.push(circle);
			}
		}
	}

	for(var b = 0; b < 10; b++) {
		box = new Box(
				WIDTH * Math.random(),
				HEIGHT * Math.random(),
				5,
				2,
				5 + Math.random() * 5
			);
		boxList.push(box);
	}


	c.addEventListener('click', function(e) {
		clickToggle = !clickToggle;
	});

	requestAnimationFrame(function loop() {
		requestAnimationFrame(loop);

		ctx.globalCompositeOperation = 'source-over';
		ctx.fillStyle = 'rgba(0, 0, 0, 0.5)';
		ctx.fillRect(0, 0, WIDTH, HEIGHT);

		ctx.fillStyle = 'white';
		ctx.fillText('傻屌！点我加特效', WIDTH / 2, HEIGHT / 2 + 100);					

		ctx.globalCompositeOperation = 'lighter';

		for(var i = 0, len = circles.length; i < len; i++) {
			circle = circles[i];
			circle.update();
			circle.render(ctx);
		}

		for(var j = 0; j < boxList.length; j++) {
			box = boxList[j];
			box.update();
			box.render(ctx);
		}

	});


});
</script>
</head>
<body>
<canvas id="c"></canvas>
</body>
</html>