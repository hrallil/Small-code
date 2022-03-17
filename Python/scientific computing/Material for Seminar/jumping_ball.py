# The intention of this code is:
# the code should project a real-world ball on a screen (surface/window) using a coordinate-converter
# (function convert) and a scaling factor (scale_real_to_screen).
# The ball's real-world diameter should be converted to pixels using the scale.
# The program should calculate and updates the ball's position, velocity and acceleration in real-world coordinates,
# convert it to a pixel position, and draw the ball on the screen at the pixel position.

# Search for the keyword "TO_BE_CHANGED"

# Scientific Computing - Roskilde University
# author: Maja H Kirkeby

# import pygame and sys modules
import pygame
import sys

# initialize pygame
pygame.init()

### colors ###
BLACK = (0,0,0)
WHITE = (255,255,255)
BLUE = (0,0,255)
RED = (255,0,0)

# define a frame rate:
frames_per_second = 60

# Initialize Real world
radius = 0.05 # radius in meters
x = 0.2  # x position in meters
y = 0.8  # y position in meters
vx = 1.0  # x velocity in meters per second
vy = 0.0  # y velocity in meters per second
g = 9.8  # Gravitational acceleration (m/s**2)

# time
t = 0.0  #  time in seconds
dt = 1 / frames_per_second  #  time increment in seconds

width = 1.0   # (meter) Position of wall to the right and width of the coordinate system
height = 1.0  # (meter) Height of the coordinate system
x_grid = 0.25 # (meter) the interval of x-axis grid of the coordinate system
y_grid = 0.2  # (meter) the interval of y-axis grid of the coordinate system

scale_real_to_screen = 600 # (pixel per meter) scale from the real-world to the screen-coordinate system

# not used in pygames
#time_in_seconds = 20.0
#steps = int(time_in_seconds * frames_per_second)  # Number of steps


# create screen:
# 1. specify screen size
screen_width, screen_height = int(width*scale_real_to_screen), int(height*scale_real_to_screen)
# 2. define screen
screen = pygame.display.set_mode((screen_width, screen_height))
# 3. set caption
pygame.display.set_caption("My Pygame Skeleton")

# update pygames clock use the framerate
clock = pygame.time.Clock()

# game loop truth value
running = True



# conversion from real-world coordinates to pixel-coordinates
def convert(real_world_x,real_world_y, scale=scale_real_to_screen, real_world_height=height):
    # TO_BE_CHANGED: calculate the pixel coordinates from the real-world coordinates and the scale
    pixel_x = 100
    pixel_y = 100
    return (pixel_x,pixel_y)


# ball: color, pixel-radius and pixel position
ball_color = BLUE
ball_radius_pix = 5 # TO_BE_CHANGED: update the pixel radius to reflect the real-world ball radius
(x_pix, y_pix) = convert(x,y)   # converts the real-world coordinates to pixel-coordinates


## draw real-world grid on screen
def draw_grid(surface, color, real_x_grid,real_y_grid,real_width=width, real_height=height):
    # vertical lines
    for i in range(int(real_width / real_x_grid)):
        pygame.draw.line(surface, color, convert(i * real_x_grid, 0),  convert(i * real_x_grid, real_height))
    # horisontal lines
    for i in range(int(real_height / y_grid)):
        pygame.draw.line(surface, color, convert(0 , i * real_y_grid ), convert(real_width, i * real_y_grid))



# game loop:
while (running):

    # loop over events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # game logic
    # draw a background using screen.fill()
    screen.fill(BLACK)

    # draw grid
    # TO_BE_CHANGED: remove the '#' to draw the grid
    # draw_grid(screen,RED,x_grid,y_grid,width,height)

    # TO_BE_CHANGED: convert the real-world coordinates to pixel-coordinates

    # draw ball using the pixel coordinates
    pygame.draw.circle(screen,ball_color,(x_pix,y_pix),ball_radius_pix)

    # print time passed, position and velocity
    # print(f"time: {t}, pos: ({x,y}), vel: ({vx,vy}, pixel pos:({x_pix},{y_pix}))")

    # TO_BE_CHANGED: update time passed, the ball's real-world acceleration, velocity, position for the next time_step


    # redraw the screen
    pygame.display.flip()

    # Limit the framerate (must be called in each iteration)
    clock.tick(frames_per_second)

# after the game loop
pygame.quit()
sys.exit()