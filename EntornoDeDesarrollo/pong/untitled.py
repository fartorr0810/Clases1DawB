import sys, pygame
# Inicializamos pygame
pygame.init()
# Muestro una ventana de 800x600
size = 800, 600
screen = pygame.display.set_mode(size)
# Cambio el título de la ventana
pygame.display.set_caption("SuperJuego BALL")
# Inicializamos variables
width, height = 800, 600
speed = [1, 1]
contador=0
white = 166, 196, 192
# Crea un objeto imagen y obtengo su rectángulo
ball = pygame.image.load("ball.png")
ballrect = ball.get_rect()
# Crea un objeto imagen bate y obtengo su rectángulo
bate = pygame.image.load("bate.png")
baterect = bate.get_rect()
bate2 = pygame.image.load("bate.png")
baterect2 = bate.get_rect()
# Pongo el bate en el centro de la pantalla
baterect.move_ip(80, 260)
baterect2.move_ip(560, 260)

# Comenzamos el bucle del juego
run=True
while run:
	# Espero un tiempo (milisegundos) para que la pelota no vaya muy rápida
	pygame.time.delay(4)
	# Capturamos los eventos que se han producido
	for event in pygame.event.get():
		#Si el evento es salir de la ventana, terminamos
		if event.type == pygame.QUIT: run = False
		# Muevo la pelota
	# Compruebo si se ha pulsado alguna tecla
	keys = pygame.key.get_pressed()
	if keys[pygame.K_UP]:
		baterect=baterect.move(0, -1)
	if keys[pygame.K_DOWN]:
		baterect=baterect.move(0, 1)
	if keys[pygame.K_w]:
		baterect2=baterect2.move(0, -1)
	if keys[pygame.K_s]:
		baterect2=baterect2.move(0, 1)
	# Compruebo si hay colisión
	if baterect.colliderect(ballrect):
		speed[0] = - speed[0]
	if event.type==ballrect.left<0:
			run=False
	# Muevo la pelota
	ballrect = ballrect.move(speed)
	#ballrect = ballrect.move(speed)
	if ballrect.left < 0 or ballrect.right > width:
		speed[0] = - speed[0]
	if ballrect.bottom <0 or ballrect.top > height:
		speed[1] = -speed[1]

	#Pinto el fondo de blanco, dibujo la pelota y actualizo la pantalla
	screen.fill(white)
	screen.blit(ball, ballrect)
	screen.blit(bate, baterect)
	screen.blit(bate, baterect2)

	pygame.display.flip()
# Salgo de pygame
pygame.quit()
