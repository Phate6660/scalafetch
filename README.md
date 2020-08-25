## scalafetch

Learning Scala, by implementing a neofetch alternative.

## help

`sbt:scalafetch> run -H`

```
-c  display cpu
-d  display the distro
-e  display $EDITOR
-g  display gpu model
-H  display this help
-h  display hostname
-k  display the kernel
-m  display currently playing music in mpd
-s  display the shell
-U  display the user
-u  display uptime
```

## Current output (from my machine)

`sbt:scalafetch> run -c true -d true -e true -g true -h true -k true -m true -s true -U true -u true`

```
CPU:       Intel(R) Core(TM) i5-3470 CPU @ 3.20GHz
Distro:    Gentoo
Editor:    /usr/bin/emacsclient
GPU:       AMD/ATI Oland Radeon HD 8570 / R7 240/340 OEM (rev 87)
Hostname:  gentoo
Kernel:    5.4.52
Shell:     /bin/bash
Uptime:    6h 2m
User:      valley
Music:     Primus - Sailing the Seas of Cheese - Here Come the Bastards
```
