#### Use cases:
### User

- presses the floor button to summon the lift
- presses the elevator button to make the lift move to the desired floor

### Floor Button/Elevator Button

- illuminates when pressed
- places a elevator request when pressed

### Elevator
- Moves up/down as per instruction
- Opens/closes the door

1. Ask
- How many elevators are there?
- What is the capacity of each elevator?
- Is the efficiency goal focused only at the start & end of day & not in between (i.e. lunch time, breaks)?
2. General optimal critiera
provide even service to each floor
minimize how long passengers wait for an elevator to arrive
minimize how long passengers spend to get to their destination floor
serve as many passengers as possible

Elevator:
    current_floor;
    status: busy/idle
    
    
Elevator accept(Command)

ElevatorAction

boolean Elevator.validate(command)

Command:
 - summon:
    currentPostion > userPosition:
        MoveDown();
    currentPostion < userPosition:
        MoveUp();
    currentPostion == userPosition:
        OpenDoor();
        
 - MoveDown(): 
    keep a list(AList) of floors in DESC order starts from current_floor;
    - MoveUp():
        keep a list(BList) of floors in ASC order starts from min(AList);
        
 - MoveUp():
    keep a list(BList) of floors in ASC order starts from current_floor;
    - MoveDown():
        keep a list(AList) of floors in Desc starts from max(BList);
        
- summon():
    if not the same direction
  
        
        
