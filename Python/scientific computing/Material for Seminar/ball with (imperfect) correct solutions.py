
# # Towards simulating a bouncing ball
# Imagine that you kick a football, so it flies through the air. Think about what happens. For you, as an individual, it might be essential whether your kick results in a goal and glory, or if it smashed the neighbours window. However, let us think more fundamentally about what goes on. Let us think scientifically.

# # Simulation requirements
# As a basis scientific problem, we want to create a simple simulation of a bouncing ball using Python 3.7 (or later) and modules. 
# The ball will inhabit a 2D space with a floor and infinitely high walls (no roof), where only gravity, floor and walls act on the ball. Because the human eye will interpret a movie with 60 frames (pictures) per second as a smooth trajectory, we will calculate the balls trajectory per time step, e.g., a time step may be 1/60 s, for a specified number of seconds, e.g., 60 seconds. 
# 
# Time is continuous and, thus, the following theory is defined for continuous time. However, because we will calculate the balls trajectory per time step, we can use a simple discrete algorithm, the leap-frog algorithm, and  focus on the discrete definitions. We will, however, also provide the continuous definitions.
# 

# ### Compute trajectory
import matplotlib.pyplot as plt

# Set (initial) simulation parameters
t = 0.0       # time in seconds
x = 0.2       # x position in meters
y = 0.8       # y position in meters
vx = 1.0      # x velocity in meters per second
vy = 0.0      # y velocity in meters per second
dt = 1/60     # time increment in seconds
g = 9.8       # Gravitational acceleration (m/s**2)
width = 1.0     # Position of wall to the right
time_in_seconds = 1.
steps = int(time_in_seconds/dt)    # Number of steps

# Print information to screen
print('Initial x position', x, 'm.')
print('Initial y position', y, 'm.')
print('Initial x velocity', vx, 'm/s.')
print('Initial y velocity', vy, 'm/s.')
print('Time increment per step:', dt, 's.')
print('Total simulation time:', steps*dt, 's.')
print('Number of time steps:', steps)


# Make list to store trajectory
tlist = [0]*steps   # List of times
xlist = [0]*steps   # List of x positions
ylist = [0]*steps   # List of y positions

# Loop though all time steps
for s in range(steps):
    
    # Save current time and positions into lists
    tlist[s] = t
    xlist[s] = x
    ylist[s] = y

    # Apply gravitational acceleration
    vy = vy - g*dt
    
    #print(f"{s}, {vx*dt}, {vy*dt}")
    
    # Update positions from velocities
    x = x + vx*dt
    y = y + vy*dt

    # Bounce
    if(y <= 0):  # Floor
        vy = -vy
        y = -y
    
    if(x < 0):  # Left wall
        vx = -vx
        x = -x

    if(x > width):  # Right wall
        vx = -vx
        x = x - 2*(x-width)    
    
    # Update time
    t = t + dt

# Plot the positions
plt.plot(xlist, ylist, 'o--')  # Plot dots connected with a line
plt.grid(color='grey', linestyle='solid')# draw solid white grid lines
plt.xlim(0, width)
plt.ylim(0, 1.0)
plt.title(f'A {time_in_seconds} seconds simulation of a bouncing ball')
plt.xlabel('x (meter)')
plt.ylabel('y (meter)')
plt.show()

