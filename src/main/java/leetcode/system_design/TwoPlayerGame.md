game
user_a, user_b, status

## Thread-Game
- player-A:Class::Player
- player-B:Class::Player
- nextAction
- Judger-Class:Judger
- state
- winner

Class::Player
- id
- name
- action
- path

Class::Map


scalable:
- multi game threads

100 games/second;
2 actions/second
200 actions/second


extensible:
- ?


QA:
1. How do you find someone to play with?
pending_player_list: random select one

2. Do you need to have a user account to play?
do not have to

3. Is there email validation?

4. Can the user choose the notification type?
yes

5. Can there be a computer player (AI)?
at first, NO. maybe later

6. Is the gameplay synchronous or asynchronous?
Sync.