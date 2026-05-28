<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Advanced Java Concepts — Ritesh</title>
<link href="https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@300;400;500;700;800&family=Syne:wght@400;600;700;800&display=swap" rel="stylesheet">
<style>
  :root {
    --java-orange: #F89820;
    --java-red: #E84135;
    --dark-bg: #0A0A0F;
    --card-bg: #0F0F1A;
    --card-border: #1E1E35;
    --text-primary: #F0F0FF;
    --text-muted: #6B6B9A;
    --text-dim: #3A3A5C;
    --accent-glow: rgba(248,152,32,0.15);
    --code-green: #4ADE80;
    --code-blue: #60A5FA;
    --code-purple: #C084FC;
    --code-cyan: #22D3EE;
  }

  * { margin: 0; padding: 0; box-sizing: border-box; }

  body {
    background: var(--dark-bg);
    color: var(--text-primary);
    font-family: 'Syne', sans-serif;
    overflow-x: hidden;
    cursor: default;
  }

  /* ─── CANVAS BACKGROUND ─────────────────────────── */
  #bg-canvas {
    position: fixed;
    top: 0; left: 0;
    width: 100%; height: 100%;
    pointer-events: none;
    z-index: 0;
    opacity: 0.35;
  }

  .content-wrap {
    position: relative;
    z-index: 1;
    max-width: 1100px;
    margin: 0 auto;
    padding: 0 2rem 6rem;
  }

  /* ─── HERO ──────────────────────────────────────── */
  .hero {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 6rem 0 4rem;
    position: relative;
  }

  .hero-badge {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: rgba(248,152,32,0.08);
    border: 1px solid rgba(248,152,32,0.25);
    border-radius: 999px;
    padding: 6px 16px;
    font-family: 'JetBrains Mono', monospace;
    font-size: 12px;
    color: var(--java-orange);
    letter-spacing: 0.08em;
    margin-bottom: 2.5rem;
    width: fit-content;
    animation: badge-pulse 3s ease-in-out infinite;
  }

  @keyframes badge-pulse {
    0%,100% { box-shadow: 0 0 0 0 rgba(248,152,32,0); }
    50% { box-shadow: 0 0 20px 4px rgba(248,152,32,0.12); }
  }

  .badge-dot {
    width: 6px; height: 6px;
    border-radius: 50%;
    background: var(--java-orange);
    animation: dot-blink 1.4s ease-in-out infinite;
  }

  @keyframes dot-blink { 0%,100%{opacity:1} 50%{opacity:0.2} }

  .hero-title {
    font-size: clamp(3rem, 8vw, 6.5rem);
    font-weight: 800;
    line-height: 1;
    letter-spacing: -0.03em;
    margin-bottom: 1rem;
  }

  .hero-title .line-1 { display: block; color: var(--text-primary); }
  .hero-title .line-2 {
    display: block;
    background: linear-gradient(90deg, var(--java-orange), var(--java-red));
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
  }

  .hero-sub {
    font-family: 'JetBrains Mono', monospace;
    font-size: 14px;
    color: var(--text-muted);
    margin: 1.5rem 0 3rem;
    max-width: 520px;
    line-height: 1.8;
  }

  .hero-sub .hl { color: var(--code-green); }

  .typewriter {
    display: inline;
    border-right: 2px solid var(--java-orange);
    animation: blink-caret 0.75s step-end infinite;
  }

  @keyframes blink-caret { from,to{border-color:transparent} 50%{border-color:var(--java-orange)} }

  .hero-cta-row {
    display: flex;
    gap: 1rem;
    flex-wrap: wrap;
    align-items: center;
  }

  .btn-primary {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: var(--java-orange);
    color: #000;
    border: none;
    border-radius: 8px;
    padding: 12px 28px;
    font-family: 'Syne', sans-serif;
    font-weight: 700;
    font-size: 14px;
    cursor: pointer;
    transition: transform 0.15s, box-shadow 0.15s;
    text-decoration: none;
  }

  .btn-primary:hover {
    transform: translateY(-2px);
    box-shadow: 0 8px 30px rgba(248,152,32,0.35);
  }

  .btn-ghost {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: transparent;
    color: var(--text-muted);
    border: 1px solid var(--card-border);
    border-radius: 8px;
    padding: 12px 24px;
    font-family: 'Syne', sans-serif;
    font-weight: 600;
    font-size: 14px;
    cursor: pointer;
    transition: border-color 0.2s, color 0.2s, transform 0.15s;
    text-decoration: none;
  }

  .btn-ghost:hover {
    border-color: var(--java-orange);
    color: var(--java-orange);
    transform: translateY(-2px);
  }

  /* ─── SCROLL HINT ──────────────────────────────── */
  .scroll-hint {
    position: absolute;
    bottom: 2rem;
    left: 0;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    gap: 8px;
  }

  .scroll-line {
    width: 1px;
    height: 60px;
    background: linear-gradient(to bottom, var(--java-orange), transparent);
    animation: scroll-anim 1.8s ease-in-out infinite;
  }

  @keyframes scroll-anim { 0%{transform:scaleY(0);transform-origin:top} 50%{transform:scaleY(1);transform-origin:top} 51%{transform:scaleY(1);transform-origin:bottom} 100%{transform:scaleY(0);transform-origin:bottom} }

  .scroll-label {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    letter-spacing: 0.2em;
    color: var(--text-dim);
    writing-mode: vertical-rl;
    text-orientation: mixed;
  }

  /* ─── STATS ROW ─────────────────────────────────── */
  .stats-row {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 1px;
    background: var(--card-border);
    border: 1px solid var(--card-border);
    border-radius: 16px;
    overflow: hidden;
    margin: 0 0 5rem;
  }

  .stat-cell {
    background: var(--card-bg);
    padding: 1.75rem 1.5rem;
    display: flex;
    flex-direction: column;
    gap: 4px;
    transition: background 0.2s;
  }

  .stat-cell:hover { background: rgba(248,152,32,0.04); }

  .stat-num {
    font-size: 2.5rem;
    font-weight: 800;
    letter-spacing: -0.03em;
    color: var(--java-orange);
    font-variant-numeric: tabular-nums;
  }

  .stat-label {
    font-family: 'JetBrains Mono', monospace;
    font-size: 11px;
    color: var(--text-muted);
    letter-spacing: 0.05em;
  }

  /* ─── SECTION HEADERS ───────────────────────────── */
  .section-header {
    display: flex;
    align-items: baseline;
    gap: 1rem;
    margin-bottom: 2.5rem;
  }

  .section-num {
    font-family: 'JetBrains Mono', monospace;
    font-size: 11px;
    color: var(--java-orange);
    letter-spacing: 0.12em;
  }

  .section-title {
    font-size: 2rem;
    font-weight: 800;
    letter-spacing: -0.02em;
  }

  .section-line {
    flex: 1;
    height: 1px;
    background: var(--card-border);
  }

  /* ─── TOPIC CARDS GRID ──────────────────────────── */
  .topics-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 16px;
    margin-bottom: 5rem;
  }

  .topic-card {
    background: var(--card-bg);
    border: 1px solid var(--card-border);
    border-radius: 14px;
    padding: 1.5rem;
    cursor: pointer;
    transition: border-color 0.25s, transform 0.2s, box-shadow 0.25s;
    position: relative;
    overflow: hidden;
  }

  .topic-card::before {
    content: '';
    position: absolute;
    inset: 0;
    background: radial-gradient(circle at var(--mx,50%) var(--my,50%), rgba(248,152,32,0.07), transparent 70%);
    opacity: 0;
    transition: opacity 0.3s;
  }

  .topic-card:hover::before { opacity: 1; }

  .topic-card:hover {
    border-color: rgba(248,152,32,0.4);
    transform: translateY(-4px);
    box-shadow: 0 20px 50px rgba(0,0,0,0.4);
  }

  .topic-card.active {
    border-color: var(--java-orange);
    box-shadow: 0 0 0 1px rgba(248,152,32,0.2), 0 20px 50px rgba(248,152,32,0.1);
  }

  .topic-icon {
    font-size: 2rem;
    margin-bottom: 1rem;
    display: block;
    transition: transform 0.3s;
  }

  .topic-card:hover .topic-icon { transform: scale(1.15) rotate(-5deg); }

  .topic-name {
    font-size: 1rem;
    font-weight: 700;
    margin-bottom: 0.4rem;
    color: var(--text-primary);
  }

  .topic-desc {
    font-family: 'JetBrains Mono', monospace;
    font-size: 11px;
    color: var(--text-muted);
    line-height: 1.6;
  }

  .topic-tag {
    display: inline-block;
    margin-top: 1rem;
    padding: 3px 10px;
    border-radius: 999px;
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    letter-spacing: 0.06em;
    background: rgba(248,152,32,0.1);
    color: var(--java-orange);
    border: 1px solid rgba(248,152,32,0.2);
  }

  /* ─── DETAIL PANEL ──────────────────────────────── */
  .detail-panel {
    background: var(--card-bg);
    border: 1px solid var(--card-border);
    border-radius: 16px;
    overflow: hidden;
    margin-bottom: 5rem;
    display: none;
  }

  .detail-panel.visible {
    display: block;
    animation: panel-in 0.35s cubic-bezier(0.23,1,0.32,1);
  }

  @keyframes panel-in {
    from { opacity:0; transform:translateY(12px); }
    to { opacity:1; transform:translateY(0); }
  }

  .panel-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 1.25rem 1.75rem;
    border-bottom: 1px solid var(--card-border);
    background: rgba(248,152,32,0.03);
  }

  .panel-title {
    font-size: 1.15rem;
    font-weight: 700;
    display: flex;
    align-items: center;
    gap: 10px;
  }

  .panel-close {
    width: 28px; height: 28px;
    border-radius: 8px;
    border: 1px solid var(--card-border);
    background: transparent;
    color: var(--text-muted);
    cursor: pointer;
    font-size: 18px;
    display: flex; align-items: center; justify-content: center;
    transition: background 0.15s, color 0.15s;
  }

  .panel-close:hover { background: rgba(255,255,255,0.05); color: var(--text-primary); }

  .panel-body {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 0;
  }

  .panel-concepts {
    padding: 1.5rem 1.75rem;
    border-right: 1px solid var(--card-border);
  }

  .concept-item {
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 0.6rem 0;
    border-bottom: 1px solid var(--card-border);
    font-size: 13px;
    color: var(--text-muted);
    transition: color 0.2s;
    cursor: default;
  }

  .concept-item:last-child { border-bottom: none; }
  .concept-item:hover { color: var(--text-primary); }

  .concept-dot {
    width: 6px; height: 6px;
    border-radius: 50%;
    background: var(--java-orange);
    flex-shrink: 0;
    opacity: 0.6;
  }

  .panel-code {
    padding: 1.5rem 1.75rem;
    position: relative;
  }

  .code-label {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    letter-spacing: 0.12em;
    color: var(--text-dim);
    margin-bottom: 0.75rem;
  }

  pre.code-block {
    font-family: 'JetBrains Mono', monospace;
    font-size: 12px;
    line-height: 1.7;
    color: #CDD6F4;
    overflow-x: auto;
    white-space: pre;
  }

  .kw { color: #CBA6F7; }
  .tp { color: #89DCEB; }
  .fn { color: #89B4FA; }
  .st { color: #A6E3A1; }
  .cm { color: #585B70; }
  .num { color: #FAB387; }

  /* ─── PROGRESS BARS ─────────────────────────────── */
  .skills-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 2rem;
    margin-bottom: 5rem;
  }

  .skill-item { }

  .skill-top {
    display: flex;
    justify-content: space-between;
    align-items: baseline;
    margin-bottom: 8px;
  }

  .skill-name {
    font-family: 'JetBrains Mono', monospace;
    font-size: 12px;
    color: var(--text-muted);
  }

  .skill-pct {
    font-family: 'JetBrains Mono', monospace;
    font-size: 12px;
    color: var(--java-orange);
  }

  .skill-bar-track {
    height: 4px;
    background: var(--card-border);
    border-radius: 999px;
    overflow: hidden;
  }

  .skill-bar-fill {
    height: 100%;
    border-radius: 999px;
    width: 0;
    background: linear-gradient(90deg, var(--java-orange), var(--java-red));
    transition: width 1.2s cubic-bezier(0.23,1,0.32,1);
  }

  /* ─── TIMELINE ──────────────────────────────────── */
  .timeline {
    position: relative;
    margin-bottom: 5rem;
    padding-left: 2rem;
  }

  .timeline::before {
    content: '';
    position: absolute;
    left: 0;
    top: 8px;
    bottom: 8px;
    width: 1px;
    background: linear-gradient(to bottom, var(--java-orange), transparent);
  }

  .tl-item {
    position: relative;
    margin-bottom: 2.5rem;
    padding-left: 1.5rem;
    opacity: 0;
    transform: translateX(-10px);
    transition: opacity 0.5s, transform 0.5s;
  }

  .tl-item.visible {
    opacity: 1;
    transform: translateX(0);
  }

  .tl-dot {
    position: absolute;
    left: -2.5rem;
    top: 4px;
    width: 10px; height: 10px;
    border-radius: 50%;
    border: 2px solid var(--java-orange);
    background: var(--dark-bg);
  }

  .tl-phase {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    color: var(--java-orange);
    letter-spacing: 0.1em;
    margin-bottom: 4px;
  }

  .tl-title {
    font-size: 1.05rem;
    font-weight: 700;
    margin-bottom: 4px;
  }

  .tl-desc {
    font-size: 13px;
    color: var(--text-muted);
    line-height: 1.6;
    max-width: 560px;
  }

  /* ─── BADGES ROW ─────────────────────────────────── */
  .badges-row {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    margin-bottom: 5rem;
  }

  .badge-tech {
    display: inline-flex;
    align-items: center;
    gap: 7px;
    padding: 8px 16px;
    border-radius: 8px;
    border: 1px solid var(--card-border);
    font-family: 'JetBrains Mono', monospace;
    font-size: 12px;
    color: var(--text-muted);
    background: var(--card-bg);
    transition: border-color 0.2s, color 0.2s, transform 0.15s;
    cursor: default;
  }

  .badge-tech:hover {
    border-color: rgba(248,152,32,0.35);
    color: var(--java-orange);
    transform: translateY(-2px);
  }

  .badge-dot-sm {
    width: 5px; height: 5px;
    border-radius: 50%;
    background: currentColor;
  }

  /* ─── FOOTER ─────────────────────────────────────── */
  .footer {
    border-top: 1px solid var(--card-border);
    padding-top: 2.5rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .footer-brand {
    font-size: 1.1rem;
    font-weight: 700;
  }

  .footer-brand span { color: var(--java-orange); }

  .footer-copy {
    font-family: 'JetBrains Mono', monospace;
    font-size: 11px;
    color: var(--text-dim);
  }

  /* ─── MISC ───────────────────────────────────────── */
  @keyframes fade-up {
    from { opacity:0; transform:translateY(20px); }
    to { opacity:1; transform:translateY(0); }
  }

  .fade-up { animation: fade-up 0.6s cubic-bezier(0.23,1,0.32,1) both; }
  .delay-1 { animation-delay: 0.1s; }
  .delay-2 { animation-delay: 0.25s; }
  .delay-3 { animation-delay: 0.4s; }
  .delay-4 { animation-delay: 0.55s; }

  @media (max-width: 768px) {
    .topics-grid { grid-template-columns: repeat(2,1fr); }
    .stats-row { grid-template-columns: repeat(2,1fr); }
    .panel-body { grid-template-columns: 1fr; }
    .panel-concepts { border-right: none; border-bottom: 1px solid var(--card-border); }
    .skills-grid { grid-template-columns: 1fr; }
  }

  /* ─── CURSOR GLOW ────────────────────────────────── */
  .cursor-glow {
    position: fixed;
    width: 300px; height: 300px;
    border-radius: 50%;
    background: radial-gradient(circle, rgba(248,152,32,0.04) 0%, transparent 70%);
    pointer-events: none;
    transform: translate(-50%,-50%);
    z-index: 0;
    transition: left 0.08s, top 0.08s;
  }
</style>
</head>
<body>

<canvas id="bg-canvas"></canvas>
<div class="cursor-glow" id="cursor-glow"></div>

<div class="content-wrap">

  <!-- HERO -->
  <section class="hero">
    <div class="hero-badge fade-up">
      <span class="badge-dot"></span>
      PGDAC · Advanced Java · CDAC
    </div>

    <h1 class="hero-title fade-up delay-1">
      <span class="line-1">Advanced</span>
      <span class="line-2">Java Concepts</span>
    </h1>

    <p class="hero-sub fade-up delay-2">
      A deep-dive repository covering <span class="hl">Collections</span>, <span class="hl">Multithreading</span>, <span class="hl">Streams</span>, <span class="hl">JDBC</span>, and more — built for <span class="hl">CDAC placement readiness</span>.<br><br>
      <span id="typewriter-text"></span><span class="typewriter"></span>
    </p>

    <div class="hero-cta-row fade-up delay-3">
      <a class="btn-primary" href="#topics" onclick="scrollToTopics()">
        ⚡ Explore Topics
      </a>
      <a class="btn-ghost" href="#">
        ☕ Java Docs
      </a>
      <a class="btn-ghost" href="#">
        ★ Star Repo
      </a>
    </div>

    <div class="scroll-hint fade-up delay-4">
      <div class="scroll-line"></div>
      <span class="scroll-label">SCROLL</span>
    </div>
  </section>

  <!-- STATS -->
  <div class="stats-row fade-up">
    <div class="stat-cell">
      <span class="stat-num" data-target="12">0</span>
      <span class="stat-label">TOPIC MODULES</span>
    </div>
    <div class="stat-cell">
      <span class="stat-num" data-target="80">0</span>
      <span class="stat-label">CODE EXAMPLES</span>
    </div>
    <div class="stat-cell">
      <span class="stat-num" data-target="50">0</span>
      <span class="stat-label">MCQ QUESTIONS</span>
    </div>
    <div class="stat-cell">
      <span class="stat-num" data-target="17">0</span>
      <span class="stat-label">JAVA VERSION</span>
    </div>
  </div>

  <!-- TOPICS GRID -->
  <div id="topics">
    <div class="section-header">
      <span class="section-num">// 01</span>
      <h2 class="section-title">Core Topics</h2>
      <div class="section-line"></div>
    </div>

    <div class="topics-grid" id="topics-grid">
      <!-- cards injected by JS -->
    </div>

    <!-- Detail panel -->
    <div class="detail-panel" id="detail-panel">
      <div class="panel-header">
        <span class="panel-title" id="panel-title">—</span>
        <button class="panel-close" onclick="closePanel()">✕</button>
      </div>
      <div class="panel-body">
        <div class="panel-concepts" id="panel-concepts"></div>
        <div class="panel-code">
          <div class="code-label">// SNIPPET PREVIEW</div>
          <pre class="code-block" id="panel-code"></pre>
        </div>
      </div>
    </div>
  </div>

  <!-- SKILLS / PROGRESS BARS -->
  <div class="section-header">
    <span class="section-num">// 02</span>
    <h2 class="section-title">Mastery Map</h2>
    <div class="section-line"></div>
  </div>

  <div class="skills-grid" id="skills-grid">
    <!-- injected -->
  </div>

  <!-- LEARNING TIMELINE -->
  <div class="section-header">
    <span class="section-num">// 03</span>
    <h2 class="section-title">Study Phases</h2>
    <div class="section-line"></div>
  </div>

  <div class="timeline" id="timeline">
    <!-- injected -->
  </div>

  <!-- TECH BADGES -->
  <div class="section-header">
    <span class="section-num">// 04</span>
    <h2 class="section-title">Stack & Tools</h2>
    <div class="section-line"></div>
  </div>

  <div class="badges-row" id="badges-row"></div>

  <!-- FOOTER -->
  <footer class="footer">
    <div class="footer-brand">Ritesh · <span>Java</span> Engineer</div>
    <div class="footer-copy">PGDAC · CDAC · 2024–25</div>
  </footer>

</div>

<!-- ─── SCRIPTS ──────────────────────────────────────── -->
<script>
/* ── DATA ── */
const topics = [
  {
    icon:'🗂️', name:'Collections Framework',
    tag:'#java.util',
    desc:'List, Set, Map, Queue hierarchies, iterators, ConcurrentModification traps',
    concepts:['ArrayList vs LinkedList','HashMap internals','TreeMap & Comparator','PriorityQueue','ConcurrentHashMap','Iterator & ListIterator','Fail-fast vs Fail-safe'],
    code:`<span class="cm">// HashMap with custom objects</span>
<span class="kw">Map</span>&lt;<span class="tp">String</span>, <span class="tp">Employee</span>&gt; map
  = <span class="kw">new</span> <span class="fn">HashMap</span>&lt;&gt;();

map.<span class="fn">put</span>(<span class="st">"E001"</span>, <span class="kw">new</span> <span class="fn">Employee</span>(<span class="st">"Ritesh"</span>, <span class="num">25</span>));

map.<span class="fn">forEach</span>((k,v) -&gt;
  System.out.<span class="fn">println</span>(k + <span class="st">" → "</span> + v)
);`
  },
  {
    icon:'🔀', name:'Multithreading',
    tag:'#concurrency',
    desc:'Thread lifecycle, synchronization, deadlock, volatile, wait/notify, ExecutorService',
    concepts:['Runnable vs Thread','synchronized keyword','wait() / notify()','volatile semantics','Deadlock prevention','ThreadPool / Executor','ReentrantLock'],
    code:`<span class="kw">ExecutorService</span> pool
  = Executors.<span class="fn">newFixedThreadPool</span>(<span class="num">4</span>);

<span class="kw">for</span> (<span class="tp">int</span> i = <span class="num">0</span>; i &lt; <span class="num">10</span>; i++) {
  <span class="tp">int</span> task = i;
  pool.<span class="fn">submit</span>(() -&gt; {
    System.out.<span class="fn">println</span>(
      <span class="st">"Task "</span> + task
    );
  });
}
pool.<span class="fn">shutdown</span>();`
  },
  {
    icon:'🌊', name:'Streams & Lambdas',
    tag:'#java8+',
    desc:'Functional pipelines, map/filter/reduce, method references, Optional, collectors',
    concepts:['Lambda expressions','Stream pipeline','filter / map / reduce','Collectors.groupingBy','flatMap','Optional chaining','Parallel streams'],
    code:`List&lt;<span class="tp">String</span>&gt; names = employees
  .<span class="fn">stream</span>()
  .<span class="fn">filter</span>(e -&gt; e.getSalary() &gt; <span class="num">50000</span>)
  .<span class="fn">map</span>(<span class="tp">Employee</span>::<span class="fn">getName</span>)
  .<span class="fn">sorted</span>()
  .<span class="fn">collect</span>(
    Collectors.<span class="fn">toList</span>()
  );`
  },
  {
    icon:'💾', name:'File I/O & NIO',
    tag:'#io.streams',
    desc:'Character & byte streams, BufferedReader/Writer, try-with-resources, NIO Paths',
    concepts:['FileReader/Writer','BufferedReader/Writer','try-with-resources','FileInputStream','Serialization','NIO Files API','Path & Paths'],
    code:`<span class="kw">try</span> (<span class="tp">BufferedReader</span> br
  = <span class="kw">new</span> <span class="fn">BufferedReader</span>(
      <span class="kw">new</span> <span class="fn">FileReader</span>(<span class="st">"data.txt"</span>))) {

  <span class="tp">String</span> line;
  <span class="kw">while</span> ((line = br.<span class="fn">readLine</span>())
    != <span class="kw">null</span>) {
    System.out.<span class="fn">println</span>(line);
  }
}`
  },
  {
    icon:'⚠️', name:'Exception Handling',
    tag:'#exceptions',
    desc:'Checked vs unchecked, custom exceptions, multi-catch, finally, exception chaining',
    concepts:['Checked vs Unchecked','Custom Exception','multi-catch (Java 7+)','finally block rules','try-with-resources','Exception chaining','StackOverflowError'],
    code:`<span class="kw">public class</span> <span class="tp">DatabaseException</span>
  <span class="kw">extends</span> <span class="tp">RuntimeException</span> {

  <span class="kw">public</span> <span class="fn">DatabaseException</span>(
    <span class="tp">String</span> msg, <span class="tp">Throwable</span> cause) {
    <span class="kw">super</span>(msg, cause);
  }
}`
  },
  {
    icon:'📦', name:'Generics & Enums',
    tag:'#types',
    desc:'Type parameters, bounded wildcards, type erasure, enum methods & fields',
    concepts:['Generic classes/methods','Bounded type params','Wildcard <? extends>','<? super> wildcard','Type erasure','Enum with fields','Enum abstract methods'],
    code:`<span class="kw">public enum</span> <span class="tp">Status</span> {
  PENDING(<span class="st">"🟡"</span>),
  ACTIVE(<span class="st">"🟢"</span>),
  CLOSED(<span class="st">"🔴"</span>);

  <span class="kw">private final</span> <span class="tp">String</span> icon;

  <span class="tp">Status</span>(<span class="tp">String</span> icon) {
    <span class="kw">this</span>.icon = icon;
  }
}`
  },
  {
    icon:'🏗️', name:'OOP & Design Patterns',
    tag:'#oop',
    desc:'SOLID principles, Singleton, Factory, Builder, Observer, Strategy pattern',
    concepts:['SOLID principles','Singleton (thread-safe)','Factory Method','Builder pattern','Observer pattern','Strategy pattern','Composition vs Inheritance'],
    code:`<span class="cm">// Thread-safe Singleton</span>
<span class="kw">public class</span> <span class="tp">Config</span> {
  <span class="kw">private static volatile</span>
    <span class="tp">Config</span> instance;

  <span class="kw">public static</span> <span class="tp">Config</span> <span class="fn">get</span>() {
    <span class="kw">if</span> (instance == <span class="kw">null</span>)
      <span class="kw">synchronized</span>(<span class="tp">Config</span>.<span class="kw">class</span>) {
        <span class="kw">if</span> (instance == <span class="kw">null</span>)
          instance = <span class="kw">new</span> <span class="fn">Config</span>();
      }
    <span class="kw">return</span> instance;
  }
}`
  },
  {
    icon:'🗄️', name:'JDBC & Databases',
    tag:'#jdbc',
    desc:'Connection pooling, PreparedStatement, ResultSet, transactions, batch updates',
    concepts:['DriverManager','PreparedStatement','ResultSet iteration','Transaction management','Batch processing','Connection pooling','SQL injection prevention'],
    code:`<span class="kw">try</span> (<span class="tp">PreparedStatement</span> ps
  = conn.<span class="fn">prepareStatement</span>(
    <span class="st">"SELECT * FROM emp WHERE id=?"</span>
  )) {

  ps.<span class="fn">setInt</span>(<span class="num">1</span>, empId);
  <span class="tp">ResultSet</span> rs = ps.<span class="fn">executeQuery</span>();
  <span class="kw">while</span> (rs.<span class="fn">next</span>()) {
    System.out.<span class="fn">println</span>(
      rs.<span class="fn">getString</span>(<span class="st">"name"</span>));
  }
}`
  },
  {
    icon:'🔁', name:'Recursion & DSA',
    tag:'#algorithms',
    desc:'JVM call stack, memoization, Tower of Hanoi, linked lists, sorting algorithms',
    concepts:['Base case design','Memoization / DP','Tower of Hanoi','Linked list ops','Binary search','QuickSort in Java','Big-O analysis'],
    code:`<span class="cm">// Fibonacci with memoization</span>
<span class="kw">static</span> <span class="tp">Map</span>&lt;<span class="tp">Integer</span>,<span class="tp">Long</span>&gt; memo
  = <span class="kw">new</span> <span class="fn">HashMap</span>&lt;&gt;();

<span class="kw">static long</span> <span class="fn">fib</span>(<span class="kw">int</span> n) {
  <span class="kw">if</span> (n &lt;= <span class="num">1</span>) <span class="kw">return</span> n;
  <span class="kw">return</span> memo.<span class="fn">computeIfAbsent</span>(
    n, k -&gt; <span class="fn">fib</span>(k-<span class="num">1</span>) + <span class="fn">fib</span>(k-<span class="num">2</span>)
  );
}`
  },
];

const skills = [
  { name:'Collections & Iterators', pct:92 },
  { name:'Multithreading & Sync',   pct:83 },
  { name:'Java 8 Streams / Lambdas', pct:88 },
  { name:'File I/O & NIO',          pct:75 },
  { name:'Exception Handling',      pct:95 },
  { name:'JDBC & SQL',              pct:80 },
  { name:'OOP & Design Patterns',   pct:85 },
  { name:'Recursion & DSA',         pct:78 },
];

const phases = [
  { phase:'PHASE 1', title:'Foundations & OOP Deep-Dive', desc:'Instances, type casting, access modifiers, packages, enums — building bulletproof OOP fundamentals.' },
  { phase:'PHASE 2', title:'Collections Framework Mastery', desc:'Every interface, every implementation, iterator trap MCQs, ConcurrentModificationException scenarios.' },
  { phase:'PHASE 3', title:'Concurrency Engineering', desc:'Thread lifecycle, synchronization primitives, deadlock patterns, ExecutorService, and volatile semantics.' },
  { phase:'PHASE 4', title:'Java 8+ Functional Style', desc:'Stream pipelines, lambda expressions, method references, Optional API, and collectors deep-dive.' },
  { phase:'PHASE 5', title:'JDBC & System Design', desc:'Database connectivity, transaction management, connection pooling, and interview-ready system design.' },
  { phase:'PHASE 6', title:'Mock Exams & Placement Prep', desc:'CDAC-style MCQ blitz, interview questions, time-boxed assessments, and placement simulation.' },
];

const badges = [
  'Java 17', 'JVM Internals', 'Maven', 'Git', 'IntelliJ IDEA',
  'MySQL', 'JDBC', 'Spring Boot', 'JUnit 5', 'Mockito',
  'REST APIs', 'Design Patterns', 'Docker (basics)', 'CDAC PGDAC',
];

/* ── CANVAS BACKGROUND ── */
(function() {
  const canvas = document.getElementById('bg-canvas');
  const ctx = canvas.getContext('2d');
  let W, H, particles = [];

  function resize() {
    W = canvas.width = window.innerWidth;
    H = canvas.height = window.innerHeight;
  }

  function spawn() {
    particles = Array.from({length: 80}, () => ({
      x: Math.random() * W,
      y: Math.random() * H,
      size: Math.random() * 1.5 + 0.3,
      vx: (Math.random() - 0.5) * 0.3,
      vy: (Math.random() - 0.5) * 0.3,
      alpha: Math.random() * 0.5 + 0.1,
    }));
  }

  function draw() {
    ctx.clearRect(0, 0, W, H);

    particles.forEach(p => {
      p.x += p.vx; p.y += p.vy;
      if (p.x < 0) p.x = W; if (p.x > W) p.x = 0;
      if (p.y < 0) p.y = H; if (p.y > H) p.y = 0;

      ctx.beginPath();
      ctx.arc(p.x, p.y, p.size, 0, Math.PI * 2);
      ctx.fillStyle = `rgba(248,152,32,${p.alpha})`;
      ctx.fill();
    });

    particles.forEach((a, i) => {
      particles.slice(i+1).forEach(b => {
        const dx = a.x-b.x, dy = a.y-b.y;
        const dist = Math.sqrt(dx*dx+dy*dy);
        if (dist < 120) {
          ctx.beginPath();
          ctx.moveTo(a.x, a.y);
          ctx.lineTo(b.x, b.y);
          ctx.strokeStyle = `rgba(248,152,32,${0.07*(1-dist/120)})`;
          ctx.lineWidth = 0.5;
          ctx.stroke();
        }
      });
    });

    requestAnimationFrame(draw);
  }

  resize(); spawn(); draw();
  window.addEventListener('resize', () => { resize(); spawn(); });
})();

/* ── CURSOR GLOW ── */
const glow = document.getElementById('cursor-glow');
document.addEventListener('mousemove', e => {
  glow.style.left = e.clientX + 'px';
  glow.style.top = e.clientY + 'px';
});

/* ── TOPIC CARD MOUSE GRADIENT ── */
document.addEventListener('mousemove', e => {
  document.querySelectorAll('.topic-card').forEach(card => {
    const rect = card.getBoundingClientRect();
    const mx = ((e.clientX - rect.left) / rect.width * 100).toFixed(1);
    const my = ((e.clientY - rect.top) / rect.height * 100).toFixed(1);
    card.style.setProperty('--mx', mx + '%');
    card.style.setProperty('--my', my + '%');
  });
});

/* ── TYPEWRITER ── */
const lines = [
  'Building scalable Java systems...',
  'Mastering concurrent programming...',
  'Cracking CDAC placement exams...',
  'Writing clean, testable code...',
];
let li = 0, ci = 0, deleting = false;
function typeLoop() {
  const el = document.getElementById('typewriter-text');
  const target = lines[li];
  if (!deleting) {
    el.textContent = target.slice(0, ++ci);
    if (ci === target.length) { deleting = true; setTimeout(typeLoop, 1800); return; }
  } else {
    el.textContent = target.slice(0, --ci);
    if (ci === 0) { deleting = false; li = (li+1)%lines.length; }
  }
  setTimeout(typeLoop, deleting ? 40 : 60);
}
typeLoop();

/* ── TOPICS GRID ── */
const grid = document.getElementById('topics-grid');
topics.forEach((t, i) => {
  const card = document.createElement('div');
  card.className = 'topic-card';
  card.innerHTML = `<span class="topic-icon">${t.icon}</span>
    <div class="topic-name">${t.name}</div>
    <div class="topic-desc">${t.desc}</div>
    <span class="topic-tag">${t.tag}</span>`;
  card.addEventListener('click', () => openPanel(i, card));
  grid.appendChild(card);
});

/* ── DETAIL PANEL ── */
let activeCard = null;
function openPanel(i, card) {
  if (activeCard) activeCard.classList.remove('active');
  activeCard = card;
  card.classList.add('active');

  const t = topics[i];
  document.getElementById('panel-title').innerHTML = `${t.icon} ${t.name}`;
  document.getElementById('panel-concepts').innerHTML = t.concepts
    .map(c => `<div class="concept-item"><div class="concept-dot"></div>${c}</div>`).join('');
  document.getElementById('panel-code').innerHTML = t.code;

  const panel = document.getElementById('detail-panel');
  panel.classList.add('visible');
  panel.scrollIntoView({ behavior:'smooth', block:'nearest' });
}

function closePanel() {
  document.getElementById('detail-panel').classList.remove('visible');
  if (activeCard) { activeCard.classList.remove('active'); activeCard = null; }
}

/* ── STATS COUNTER ── */
function animateCounters() {
  document.querySelectorAll('[data-target]').forEach(el => {
    const target = +el.dataset.target;
    let current = 0;
    const inc = target / 50;
    const timer = setInterval(() => {
      current = Math.min(current + inc, target);
      el.textContent = Math.floor(current) + (target === 17 ? '' : '+');
      if (current >= target) clearInterval(timer);
    }, 25);
  });
}
setTimeout(animateCounters, 400);

/* ── SKILLS ── */
const sg = document.getElementById('skills-grid');
skills.forEach(s => {
  const d = document.createElement('div');
  d.className = 'skill-item';
  d.innerHTML = `<div class="skill-top">
    <span class="skill-name">${s.name}</span>
    <span class="skill-pct">${s.pct}%</span>
  </div>
  <div class="skill-bar-track">
    <div class="skill-bar-fill" data-pct="${s.pct}"></div>
  </div>`;
  sg.appendChild(d);
});

/* ── SKILLS ANIMATE ON SCROLL ── */
const skillObs = new IntersectionObserver(entries => {
  entries.forEach(e => {
    if (e.isIntersecting) {
      document.querySelectorAll('.skill-bar-fill').forEach(bar => {
        bar.style.width = bar.dataset.pct + '%';
      });
      skillObs.disconnect();
    }
  });
}, { threshold: 0.3 });
skillObs.observe(document.getElementById('skills-grid'));

/* ── TIMELINE ── */
const tl = document.getElementById('timeline');
phases.forEach(p => {
  const item = document.createElement('div');
  item.className = 'tl-item';
  item.innerHTML = `<div class="tl-dot"></div>
    <div class="tl-phase">${p.phase}</div>
    <div class="tl-title">${p.title}</div>
    <div class="tl-desc">${p.desc}</div>`;
  tl.appendChild(item);
});

const tlObs = new IntersectionObserver(entries => {
  entries.forEach(e => {
    if (e.isIntersecting) {
      e.target.classList.add('visible');
    }
  });
}, { threshold: 0.2 });
document.querySelectorAll('.tl-item').forEach((item, i) => {
  item.style.transitionDelay = (i * 0.1) + 's';
  tlObs.observe(item);
});

/* ── BADGES ── */
const br = document.getElementById('badges-row');
badges.forEach(b => {
  const badge = document.createElement('div');
  badge.className = 'badge-tech';
  badge.innerHTML = `<span class="badge-dot-sm"></span>${b}`;
  br.appendChild(badge);
});

/* ── SCROLL TO TOPICS ── */
function scrollToTopics() {
  document.getElementById('topics').scrollIntoView({ behavior:'smooth' });
}
</script>
</body>
</html>