## Cover Letter:
Woah, I couldn't believe it when I saw this Ad on LinkedIn, I know it's a long shot, but I couldn't be any more excited for a job application.

I've always wanted to have a Flipper Zero, but since I transitioned from Electronic to DevOps Engineer I stoped buying stuff as I had, and still have, my closet full 
of prototype mini computers and microcontrollers, as well as all the accessory sensors, shields, custom boards, power supplies and who knows what else.

The Flipper Zero was one of the coolest devices I've seen a review of and just to be closer to the team that made it happen is such a thrilling opportunity for learning.

I've always been a hacky guy since my early childhood, I would tear my toys to pieces to build the perfect one. 
On my first year of high school while I was learning color theory I use my train variable transformer to control a DC motor 
I pulled from an electric car to drive a flat disc with the rainbow colors drawn as a pie chart until I found the 
velocity needed to turn it white. None of the other kids could spin it so fast and steady to get the illusion working. 

I have several stories like this, I've rooted my phones, changed the firmware on Sonoffs to connect them to Openhab2 and 
designed custom shields and sensor to improve what it was on the market or just for fun. I used to fix general appliances 
too, but only when it was worth the time, which is almost never.

The technical stuff is below, I wanted to get you a sense of how long I've troubleshooting and optimizing things.
Please consider me for this role, I am a lot more skillful that what I can convey in these short words.

## Application requirements review

Below, I detail how my experience with the tools mentioned and particular projects I worked in may help you decide whether I'm the perfect guy for the job.

**Requirements**

    Linux – advanced level: architectural knowledge, deployment, debugging
    K8S – advanced level: architecture, public and private clouds, networking (including service mesh), debugging
    Docker – packaging web services and auxiliary tools
    Observability – Monitoring (Zabbix/Nagios, etc), Logging (graylog, logstash, etc), Metrics (Prometheus) Networks – OSI Model, Linux network stack
    Python – for practical tasks related to automation of deployment, testing, monitoring

There are probably some people better than I to do troubleshooting in these kind of platforms, but I don't think you can find one as easily.
Seriously, my brain is designed for this and my problem is to let go, so I can eat, sleep and survive while I'm debugging an issue.
I could be wrong of course, I'm pretty sure have next level troubleshooters in your company.

### Linux:

I've worked in Netlabs after being a Datacenter Technical Leader for IBM just because they were a RedHat partner and known to have the best Linux Sys Admins.
I went from being responsible for two datacenters operations to a Junior Sys Admin just get the best mentors and I did at least for Linux.

Anything from IP tables, SE-Linux, file ACLs, LVM, Firewalls, User management and permissions and file systems, including Ceph, GlusterFS and NFS. 
I've used Apache, Nginx and HA proxy in Linux, Pfsense and LDAP servers and much more.

I'm a little rusty since in the Cloud DevOps/Microservices world is not used as much as in old Linux server based applications. 
but still use bash a lot to glue everything together for pipelines.

Please check [this project](https://github.com/andresr27/portfolio/blob/master/Readme.md#product-developer-for-antel-ndg on my CV 
and [this experiece](https://github.com/andresr27/portfolio/blob/master/Readme.md#20182019-reliability-engineer-netlabs-hg-offices-montevideo-uruguay).


### K8 and Docker:
I've put these two together, because I've always used together, I've deployed several type of applications to kubernetes 
including Spring-boot built with Gradle and Maven, also Python applications modules and Node website using Express and Next and 
I've just learnt about Nuxt because of this job posting.


I'm familiar with importance of: 
- Light containers for better resource allocation.
- Build Tag Push process and registry management as well as using the correct image update parameters.
- Propper Liveness and Readiness Checks to improve availability.
- Actuators and likes to publish internal metrics for better monitoring and scaling, horizontally and vertically.
- Managing virtual physical volumes configuration to mange data retention, after deployment deletion for example.
- How to deploy Daemon sets, Stateful Sets, Deployments, Cron Jobs, etc.
- How to migrate cluster versions and load to specific node groups.
- The difference between nginx-controller form K8s and kubernetes-controller from Nginx.
- How to configure Virtual Servers, Virtual Routes, API, Targets, Service Accounts, Secrets, Config Maps, etc.

### Observability:

I've used all of them, for Nagios I just created configured container from exports from linux instances. 
However, I would use Opensearch with OTEL and Data Prepper to substitute of all of them. 
They look old compared to these new tools, and you get a true APM with Metrics, Logging and Traces for a fraction of the cost of a SaaS product. 
Most of my experience comes form building mixed environment Grafana/Prometheus for metrics and Opensearch/Fluent-bit for logging 
pretty powerful and robust, but it can be simplified.

Please check [this project](https://github.com/andresr27/portfolio/blob/master/Readme.md#senior-devops-engineer--upwave) for my best experience with Kubernetes and Observability


## Nice-to-haves
### MacOS, Windows skills
I used Mac in my last two jobs and manged Windows servers for SCADA system with MS SQL. Also, used Windows in other jobs, specially the earlier ones. 
I still keeps a Windows computer to test Openvpn connections and other agents.

### Knowledge of GitHub/GitLab CI/CD

Is really not that big of deal, everything you in a Linux box you can do it in remote executioner just have to give the 
right permissions to your infrastructure and  packages used. 

I did [this GitHub Actions course](https://www.linkedin.com/learning/github-actions-for-ci-cd) with the learning trial in LinkedIn resulting in this action: https://github.com/andresr27/advanced-github-actions

The key is to have good testing for stage of CI/CD peer review process. 
I would love to try Blue/Green or Canary deployment someday but no company I've worked for has gotten that far.


### Experience configuring L2/L3 network equipment  
So, I as electronic engineer we have a solid foundation in Networking models. I, particularly, did my Thesis building devices
that implemented an RS-485 over FHDSS (Frequency Hopping Direct Spread Spectrum) to interconnect industrial device over a master salve wireless network.
I got to program Atmel microcontroller in C/Assembler configuring the Transceiver interruption response routines.
I've physical switches and routers (Cisco), F5 Load Balancer, Linux Apache and Nginx reverse proxies and load balances, including different load balancing strategies like Cookies, sticky, MAC, IP.
Same for K8s port forwarding and ingress controller configuration.

## Your responsibilities

### Managing Flipper Devices infrastructure and k8s
Can't think of any better task than this. Check [my experience at Boxes](https://github.com/andresr27/portfolio/tree/master?tab=readme-ov-file#20142019-technical-leader-boxes-montevideo-uruguay),
it was one of the coolest side projects I've had and I really made a difference the software, the hardware and management console, while training future engineer take the lead.

### Improving infrastructure access control policies
Policy is the security enforcer, together with configuration management are key and primary aspects that we need ot ensure 
a secure and reliable infrastructure while limiting costs surges.
I've configured policies in AWS, Terraform, Databricks, Kubernetes, and also in Linux.

### Reviewing and improving deployment automation processes
This is the DevOps mindset on my first job as sysAdmin Developer had me go to the office at night just to deploy a Java binary in Jboss.
These days, I give them everything preconfigured and explained, so hopefully they'd only write to say thank you and that they've love the documentation.

### Expanding existing monitoring systems
That probably my best and hardest selling point. I love Opensearch but maybe is too much, yes but once they see it working no ones wants to go back. 
I like Zabbix, we did pretty robust endpoint testing with it and loved the integration with Telegram we used for Notifications and Alerts.


### Building processes for regular infrastructure audits

All the companies I worked in Uruguay were ISO-9001 compliant and both IBM and ANTEL/HG also implemented ISO-27001. I audited roles, 
was audited and was responsible for one the security process for the latter.

In this new age, I would suggest a digital inventory updated regularly that we can run a vulnerability analyzer and build a report that help build the action plan.
I did this for Upwave using AWS System Manager Inventory, SSM agent and TWIGS to build the reports.


### Incident management

I like IBM way of thinking in this respect. There needs to be a clear understanding of:
- Incident classification
- Acknowledged response times 
- Backup and rotation plans
- Clear Scalation process
- Right communication tools
- Clean Alarm panels, no noisy alerts
- Centralized easy to find documentation

We also need to test the process to make problem evident before an incident. The quality of the incident response a reflections of the work we put before it.
Nothing worse than have your CTO calling you at 6am in the morning to debug a Kubernetes platform running a crashed service with no idea of how it was build or what is really doing.
These are tough days, unplaned 16 hours troubleshooting sessions is probably the worst in this career, specially when you have plans. 
In moments like this I appreciate the linux history command, the framework documentation, and some angels that show up to fill me in with key information to resolve it.


### Final note

I hope this gives you rounded idea o what I can deliver, I'm looking forward to talk if you want to know more. If not, thanks for the Flippers they 
are amazing devices and I really want to get them all.

