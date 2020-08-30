/**
 * Adds a perscribed role to all members of a guild.
 */

const Discord = require('discord.js');
const dotenv = require('dotenv');
const {promisify} = require('util');

const client = new Discord.Client();
dotenv.config();

client.login(process.env.API_TOKEN);

const sleep = promisify(setTimeout);

client.on('ready', async () => {
    const guild = client.guilds.resolve(process.env.GUILD_ID);
    console.log(`Resolved Guild ${guild.name}`);
    const role = guild.roles.resolve(process.env.ROLE_ID);
    console.log(`Resolved Guild ${role.name}`);
    const members = guild.members.cache.array().filter(member => 
        !member.roles.cache
            .array()
            .map(role => role.id)
            .includes(process.env.ROLE_ID)
    );
    console.log(`Adding roles to ${members.length} users in 5s.`);
    await sleep(5000);
    const start = Date.now();
    let cnt = 0;
    for (const member of members) {
        console.log(`Adding role to ${member.user.tag}`);
        await member.roles.add(role, 'New Default Role for Programmers Palace.');
        if (++cnt % 50 === 0)
            console.log(`PROGRESS UPDATE: Added to ${cnt} members!`);
        await sleep(150);
    }
    const time = Math.round((Date.now() - start) / 1000); // s
    console.log(`Completed ${cnt} members in ${time}s`)
})