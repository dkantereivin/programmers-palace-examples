# Discord Mass Role Giver
Contributed by [Canter#0548](https://github.com/dkantereivin).

A utility written in NodeJS used whenever Programmers Palace (or any guild)
needs to assign a newly created role to all members of the server.

## Usage
1. Copy `.env.template` into a new file named `.env` and then delete `.env.template`.
2. Fill out the environment variables, and ensure that the bot has manage role permissions, and that it has a role hoisted above the target role.
3. Run the script.

### Why?
This utility is particularly useful whenever new roles are introduced as defaults.
For example, [Programmers Palace](https://www.programmerspalace.com) used it when
introducing the `Member` and `Community Ping` roles.