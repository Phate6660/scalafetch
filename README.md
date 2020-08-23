## scalafetch

Learning Scala, by implementing a neofetch alternative.

Currently supported: distro and kernel.

## help

`sbt:scalafetch> run -H`

```
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

`sbt:scalafetch> run -d true -e true -g true -h true -k true -m true -s true -U true -u true`

```
Distro:    Gentoo
Editor:    /usr/bin/emacsclient
GPU:       AMD/ATI Cedar Radeon HD 5000/6000/7350/8350 Series
Hostname:  gentoo
Kernel:    5.4.48-ck-valley
Shell:     /bin/bash
Uptime:    1d 10h 45m
User:      valley
Music:     Mr. Bungle - Mr. Bungle - Carousel
```
