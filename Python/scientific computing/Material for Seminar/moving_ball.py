# This code displays a ball on the screen (surface/window)
# it uses a pixel position, and a pixel-radius.

# To Do:
# 1. Update the following code so that the current time is updated with the length of the timestep (dt),
#    ball's position (pixels) is updated using the velocity (in pixels)
# 2. insert a black background so that it looks like the ball is moving
# 3. what is the greatest velocity that does not move the ball?

# Scientific Computing - Roskilde University
# author: Maja H Kirkeby

# import pygame and sys modules
import pygame
import sys

# initialize pygame
pygame.init()

# create screen:
# 1. specify screen size
screen_width, screen_height = 800, 600
# 2. define screen
screen = pygame.display.set_mode((screen_width, screen_height))
# 3. set caption
pygame.display.set_caption("Not my Pygame Skeleton")

### colors ###
BLACK = (0,0,0)
WHITE = (255,255,255)
BLUE = (0,0,255)

# define a frame rate:
frames_per_second = 60

# update pygames clock use the framerate
clock = pygame.time.Clock()

# game loop truth value
running = True

# ball: color, pixel-position, and pixel-radius
ball_color = BLUE
ball_radius_pix = 10
x_pix = 100
y_pix = 60

# ball velocity
vx_pix = 2
vy_pix = 1

# time: time step and current time
t = 0.0
dt = 1 / frames_per_second

# game loop:
while (running):

    # loop over events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # game logic
    # TO_BE_CHANGED: draw a background using screen.fill()


    # draw ball
    pygame.draw.circle(screen,ball_color,(x_pix,y_pix),ball_radius_pix)
    # print time passed, position and velocity
    print(f"time: {t}, pos: ({x_pix, y_pix}), vel: ({vx_pix, vy_pix})")
    # TO_BE_CHANGED: update time passed, and ball's position for next time_step


    # redraw the screen
    pygame.display.flip()

    # Limit the framerate (must be called in each iteration)
    clock.tick(frames_per_second)

# after the game loop
pygame.quit()
sys.exit()