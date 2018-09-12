# Mobile-Phone-Tracking-System
Implemented a data structure that will help solve a simplified version of the mobile phone tracking problem, i.e., the fundamental problem of cellular networks: When a phone is called, find where it is located so that a connection may be established.

## Mobile phone tracking system description
As we know each mobile phone that is switched on is connected to the base station which is nearest. These base stations are popularly called cell phone towers. Although sometimes we may be within range of more than one base station, each phone is registered to exactly one base station at any point of time. When the phone moves from the area of one base station to another, it will be de-registered at its current base station and re-registered at new base station.

<b>Making a phone call.</b> When a phone call is made from phone <em>p<sub>1</sub></em> registered with base station <em>b<sub>1</sub></em> to a phone <em>p<sub>2</sub></em>, the first thing that the base station <em>b<sub>1</sub></em> has to do is to find the base station with which <em>p<sub>2</sub></em> is registered. For this purpose there is an elaborate technology framework that has been developed over time. You can read more about it on the Web. But, for now, we will assume that <em>b<sub>1</sub></em> sends a query to a central server <em>C</em> which maintains a data structure that can answer the query and return the name of the base station, let’s call it <em>b<sub>2</sub></em>, with which <em>p<sub>2</sub></em> is registered. <em>C</em> will also send some routing information to <em>b<sub>1</sub></em> so that <em>b<sub>1</sub></em> can initiate a call with <em>b<sub>2</sub></em> and, through the base stations <em>p<sub>1</sub></em> and <em>p<sub>2</sub></em> can talk. It is the data structure at <em>C</em> that we will be implementing in this assignment.

<b>A hierarchical call routing structure.</b> We will assume that geography is partitioned in a hierarchical way. At the lowest level is the individual base station which defines an area around it such that all phones in that area are registered with it, e.g., all phones that are currently located in Bharti building, School of IT and IIT Hospital are registered with the base station in Jia Sarai. This base station also serves phone in Jia Sarai and maybe some phones on Outer Ring Road in front of Jia Sarai. Further we assume that base stations are grouped into geographical locations served by an <em>level 1 area exchange</em>. So, for example, the Jia Sarai base station may be served by the Hauz Khas level 1 area exchange. Each level <em>i</em> area exchange is served by a level <em>i</em> + 1 area exchange which serves a number of level <em>i</em> area exchanges, e.g., the Hauz Khas level 1 area exchange and the Malviya level 1 area exchange may be both served by a South-Central Delhi level 2 area exchange. A base station can be considered to be a level 0 area exchange in this hierarchical structure. Given a level <em>i</em> exchange <em>f</em>, we say that the level <em>i</em> + 1 exchange that serves it is the parent of <em>f</em>, and denote this parent(<em>f</em>). 
We will call this hierarchical call routing structure the <em>routing map</em> of the mobile phone network.

<b>Maintaining the location of mobile phones.</b> Every level <em>i</em> area exchange, <em>e</em>, maintains a set of mobile phones, <em>S<sub>e</sub></em>, as follows. The set <em>S<sub>e</sub></em> is called the <em>resident set</em> of <em>e</em>. The level 0 area exchanges (base stations) maintain the set of mobile phones registered directly with them. A level <em>i</em>+1 area exchange <em>e</em>, maintains the set <em>S<sub>e</sub></em> defined as the union of the sets of mobile phones maintained by all the level <em>i</em> area exchanges it serves. Clearly, the root of the routing map maintains the set of all currently registered mobile phones.

<b>Tracking a mobile phone.</b> The routing map along with the resident sets of each area exchange makes up the mobile phone tracking data structure we will be using. This data structure will be stored at the central server <em>C</em>. The process of tracking goes as follows.
<ul>
<li>When a base station <em>b</em> receives a call for a mobile phone with number <em>m</em> it sends this query to <em>C</em>.</li>
<li>If the root of the routing map is <em>r</em>, we first check if <em>m</em> ∈ <em>S<sub>r</sub></em>. If not then we tell <em>b</em> that the number <em>m</em> is “not reachable.”</li>
<li>If <em>m</em> ∈ <em>Sr</em> we find that <em>e</em> such that parent(<em>e</em>) = <em>r</em> and <em>m</em> ∈ <em>S<sub>e</sub></em>, i.e. we find the child of <em>r</em> which contains <em>m</em> in its resident set.</li>
<li>Continue like this till we reach all the way down to a leaf of the routing map. This leaf is a base station <em>b'</em>.</li>
<li>The central server sends <em>b'</em> to <em>b</em> along with the path in the routing map from <em>b</em> to <em>b'</em>.</li>
</ul>

