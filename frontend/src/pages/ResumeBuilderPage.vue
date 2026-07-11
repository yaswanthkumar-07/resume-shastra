<script setup>
import BuilderHeader from "../components/BuilderHeader.vue";
import Sidebar from "../components/Sidebar.vue";
import PreviewPanel from "../components/PreviewPanel.vue";
</script>

<template>

<div class="h-screen flex flex-col">

    <BuilderHeader />

    <div class="flex flex-1 overflow-hidden">

        <Sidebar />

        <PreviewPanel />

    </div>

</div>

</template>